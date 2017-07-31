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

import cse.duytan.coms.R;
import cse.duytan.coms.dialogs.ConfirmOkDialog;
import cse.duytan.coms.dialogs.ProcessDialog;
import cse.duytan.coms.untils.Constants;
import cse.duytan.coms.untils.DebugLog;
import cse.duytan.coms.untils.Utils;
import okhttp3.Call;
import okhttp3.Callback;
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

    public static DownloadAsyncTask getInstance() {
        return ourInstance;
    }

    private DownloadAsyncTask() {
    }

    public static <T> T GET(@NonNull final Context context, @NonNull final int processId, @NonNull String url, final Class<T> type, boolean showDialog, @NonNull final DownloadCallback downloadCallback) {
        try {
            if (!Utils.isConnectionAvailable(context)) {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_no_internet));
                    }
                });
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    showError(context, processId, downloadCallback);
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.toString());
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
                        showError(context, processId, downloadCallback);
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                }
            });
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T POST(@NonNull final Context context, @NonNull final int processId, @NonNull final String url, String body, final Class<T> type, boolean showDialog, @NonNull final DownloadCallback downloadCallback) {
        try {
            if (!Utils.isConnectionAvailable(context)) {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_no_internet));
                    }
                });
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();

            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(JSON, body);
            final Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    showError(context, processId, downloadCallback);
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.toString());
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
                        showError(context, processId, downloadCallback);
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                }
            });
            DebugLog.logD(TAG, "DOWNLOAD_EXCEPTION: " + e.toString());
            return null;
        }
    }

    private static void showError(final Context context, final int processId, final DownloadCallback downloadCallback) {
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
            }
        });
    }

    private static <T> T jsonParser(Context context, String json, final int processId, final DownloadCallback downloadCallback, final Class<T> type) {
        try {
            JSONObject mainData = new JSONObject(json);
            int errorCode = mainData.has("errorCode") ? mainData.getInt("errorCode") : -1;
            final String message = mainData.has("message") ? mainData.getString("message") : "";
            final Object data = mainData.isNull("data") ? null : mainData.get("data");
            if (errorCode == 0) {
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
            } else {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        downloadCallback.downloadError(processId, message);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            DebugLog.logD(TAG, "PARSER_JSON: " + "JSON trả về không đúng định dạng");
        }
        return null;
    }

}
