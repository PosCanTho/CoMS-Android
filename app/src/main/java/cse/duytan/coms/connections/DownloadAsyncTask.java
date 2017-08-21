package cse.duytan.coms.connections;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.dialogs.ProcessDialog;
import cse.duytan.coms.helpers.Prefs;
import cse.duytan.coms.models.Token;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Pham Van Thien on 7/6/2017.
 * Email: pvthiendeveloper@gmail.com
 * Phone: 0979477093
 */

public class DownloadAsyncTask extends OkHttpClient implements Constants {
    private static final DownloadAsyncTask ourInstance = new DownloadAsyncTask();
    private static ProcessDialog processDialog;
    private static OkHttpClient client;
    private static Token token;

    public static DownloadAsyncTask getInstance() {
        return ourInstance;
    }

    private DownloadAsyncTask() {
    }

    public static <T> T GET(@NonNull final Context context, @NonNull final int processId, @NonNull String url, final Class<T> type, boolean showDialog, @NonNull final DownloadCallback downloadCallback) {
        try {
            token = Prefs.getToken();
            if (!Utils.isConnectionAvailable(context)) {
                showError(context, processId, context.getString(R.string.msg_sorry_no_internet), downloadCallback);
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();

            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", "application/json");
            map.put("Accept", "application/json");
            if (token != null) {
                map.put("authorization", token.getToken_type() + " " + token.getAccess_token());
            }
            Headers headers = Headers.of(map);

            final Request request = new Request.Builder()
                    .headers(headers)
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    if(e.getMessage().equals("timeout")){
                        showError(context, processId, context.getString(R.string.msg_connection_time_out_please_try_again), downloadCallback);
                    }else{
                        showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                    }
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    processDialog.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            final String json = response.body().string();
                            DebugLog.logD(TAG, "DOWNLOAD_RESPONSE: " + json);
                            jsonParser(context, json, processId, downloadCallback, type);
                        } catch (Exception e) {
                            DebugLog.logD(TAG, "DOWNLOAD_PARSER_ERROR: " + e.toString() + " (Dữ liệu trả về không giống với đối tượng truyền vào)");
                        }
                    } else {
                        if (response.message().equals("Unauthorized")) {
                            showError(context, processId, context.getString(R.string.msg_connection_timed_please_log_in_again), downloadCallback);
                        } else {
                            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                        }
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T POST(@NonNull final Context context, @NonNull final int processId, @NonNull final String url, String body, final Class<T> type, boolean showDialog, @NonNull final DownloadCallback downloadCallback) {
        try {
            token = Prefs.getToken();
            if (!Utils.isConnectionAvailable(context)) {
                showError(context, processId, context.getString(R.string.msg_sorry_no_internet), downloadCallback);
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();

            Map<String, String> map = new HashMap<>();
            map.put("Content-Type", "application/json");
            map.put("Accept", "application/json");
            if (token != null) {
                map.put("authorization", token.getToken_type() + " " + token.getAccess_token());
            }
            Headers headers = Headers.of(map);

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(JSON, body);
            final Request request = new Request.Builder()
                    .url(url)
                    .headers(headers)
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    if (e.getMessage().equals("timeout")) {
                        showError(context, processId, context.getString(R.string.msg_connection_time_out_please_try_again), downloadCallback);
                    } else {
                        showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                    }
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    processDialog.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            final String json = response.body().string();
                            DebugLog.logD(TAG, "DOWNLOAD_RESPONSE: " + json);
                            jsonParser(context, json, processId, downloadCallback, type);
                        } catch (Exception e) {
                            DebugLog.logD(TAG, "DOWNLOAD_PARSER_ERROR: " + e.toString() + " (Dữ liệu trả về không giống với đối tượng truyền vào)");
                        }
                    } else {
                        if (response.message().equals("Unauthorized")) {
                            showError(context, processId, context.getString(R.string.msg_connection_timed_please_log_in_again), downloadCallback);
                        } else {
                            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                        }
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
            DebugLog.logD(TAG, "DOWNLOAD_EXCEPTION: " + e.toString());
            return null;
        }
    }

    public static <T> T POST(@NonNull final Context context, @NonNull final int processId, @NonNull final String url, Request request, final Class<T> type, boolean showDialog, @NonNull final DownloadCallback downloadCallback) {
        try {
            if (!Utils.isConnectionAvailable(context)) {
                showError(context, processId, context.getString(R.string.msg_sorry_no_internet), downloadCallback);
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    if (e.getMessage().equals("timeout")) {
                        showError(context, processId, context.getString(R.string.msg_connection_time_out_please_try_again), downloadCallback);
                    } else {
                        showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                    }
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    processDialog.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            final String json = response.body().string();
                            DebugLog.logD(TAG, "DOWNLOAD_RESPONSE: " + json);
                            jsonParser(context, json, processId, downloadCallback, type);
                        } catch (Exception e) {
                            DebugLog.logD(TAG, "DOWNLOAD_PARSER_ERROR: " + e.toString() + " (Dữ liệu trả về không giống với đối tượng truyền vào)");
                        }
                    } else {
                        if (response.message().equals("Unauthorized")) {
                            showError(context, processId, context.getString(R.string.msg_connection_timed_please_log_in_again), downloadCallback);
                        } else {
                            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                        }
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
            DebugLog.logD(TAG, "DOWNLOAD_EXCEPTION: " + e.toString());
            return null;
        }
    }


    private static void showError(final Context context, final int processId, final String msg, final DownloadCallback downloadCallback) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                downloadCallback.downloadError(processId, msg);
            }
        });
        if (processDialog != null) {
            processDialog.dismiss();
        }
    }

    private static <T> T jsonParser(Context context, String json, final int processId, final DownloadCallback downloadCallback, final Class<T> type) {
        try {
            final JSONObject mainData = new JSONObject(json);
            int errorCode = mainData.has(ERROR_CODE) ? mainData.getInt(ERROR_CODE) : -1;
            final String message = mainData.has(MESSAGE) ? mainData.getString(MESSAGE) : "";
            final Object data = mainData.isNull(DATA) ? null : mainData.get(DATA);
            if (errorCode == 0) {//JSON trả về đúng định dạng có message, errorCode, data
                if (data != null && data instanceof JSONObject && type != null) {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            downloadCallback.downloadSuccess(processId, new Gson().fromJson(data.toString(), type));
                        }
                    });
                } else if (data != null && data instanceof JSONArray && type != null) {
                    JSONArray array = (JSONArray) data;
                    int lengh = array.length();
                    final ArrayList<Object> listObject = new ArrayList<>();
                    for (int i = 0; i < lengh; i++) {
                        JSONObject object = array.getJSONObject(i);
                        listObject.add(new Gson().fromJson(object.toString(), type));
                    }
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            downloadCallback.downloadSuccess(processId, listObject);
                            Log.d(TAG, "run: " + listObject.size());
                        }
                    });
                } else {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            downloadCallback.downloadSuccess(processId, message);
                        }
                    });
                }
            } else if (errorCode == -1) {//JSON trả về không đúng định dạng message, errorCode, data
                if (mainData != null && mainData instanceof JSONObject && type != null) {
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            downloadCallback.downloadSuccess(processId, new Gson().fromJson(mainData.toString(), type));
                        }
                    });
                } else if (mainData.has("Message")) {
                    showError(context, processId, context.getString(R.string.msg_please_log_in_again), downloadCallback);
                } else {
                    showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
                    DebugLog.logD(TAG, "PARSER_JSON: " + "JSON trả về rỗng hoặc không truyền đối tượng để phân tích.");
                }
            } else {
                showError(context, processId, message, downloadCallback);
            }
        } catch (Exception e) {
            showError(context, processId, context.getString(R.string.msg_sorry_an_has_occurred), downloadCallback);
            e.printStackTrace();
            DebugLog.logD(TAG, "PARSER_JSON: " + "JSON trả về không đúng định dạng");
        }
        return null;
    }

}
