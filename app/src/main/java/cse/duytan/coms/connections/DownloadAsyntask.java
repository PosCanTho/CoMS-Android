package cse.duytan.coms.connections;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import cse.duytan.coms.R;
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

public class DownloadAsynTask extends OkHttpClient implements Constants {
    private static final DownloadAsynTask ourInstance = new DownloadAsynTask();
    private static ProcessDialog processDialog;
    private static OkHttpClient client;

    public static DownloadAsynTask getInstance() {
        return ourInstance;
    }

    private DownloadAsynTask() {
    }

    public static <T> T GET(final Context context, final int processId, String url, final Class<T> type, boolean showDialog, final DownloadCallback downloadCallback) {
        try {
            if (!Utils.isConnectionAvailable(context)) {
                downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_no_internet));
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
                    downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    processDialog.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            String json = response.body().string();
                            String data = json.substring(0, json.length() - 10);
                            DebugLog.logD(TAG, "DOWNLOAD_RESPONSE: " + data);
                            downloadCallback.downloadSuccess(processId, new Gson().fromJson(data, type));
                        } catch (Exception e) {
                            DebugLog.logD(TAG, "DOWNLOAD_PARSER_ERROR: " + e.toString() + " (Dữ liệu trả về không giống với đối tượng truyền vào)");
                        }
                    } else {
                        downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
            DebugLog.logD(TAG, "DOWNLOAD_EXCEPTION: " + e.toString());
            return null;
        }
    }

    public static <T> T POST(final Context context, final int processId, final String url, String body, final Class<T> type, boolean showDialog, final DownloadCallback downloadCallback) {
        try {
            if (!Utils.isConnectionAvailable(context)) {
                downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_no_internet));
                return null;
            }
            processDialog = new ProcessDialog(context);
            if (showDialog) processDialog.show();
            DebugLog.logD(TAG, "URL_REQUEST: " + url);
            client = new OkHttpClient();

            MediaType JSON
                    = MediaType.parse("application/json; charset=utf-8");
            RequestBody requestBody = RequestBody.create(JSON, body);
            final Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .post(requestBody)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    processDialog.dismiss();
                    downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                    DebugLog.logD(TAG, "DOWNLOAD_ONFAILURE: " + e.toString());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    processDialog.dismiss();
                    if (response.isSuccessful()) {
                        try {
                            String json = response.body().string();
                            String data = json.substring(0, json.length() - 10);
                            DebugLog.logD(TAG, "DOWNLOAD_RESPONSE: " + data);
                            downloadCallback.downloadSuccess(processId, new Gson().fromJson(data, type));
                        } catch (Exception e) {
                            DebugLog.logD(TAG, "DOWNLOAD_PARSER_ERROR: " + e.toString() + " (Dữ liệu trả về không giống với đối tượng truyền vào)");
                        }
                    } else {
                        downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
                        DebugLog.logD(TAG, "DOWNLOAD_ONRESPONE: " + response.message() + " (Truyền sai tham số)");
                    }
                }
            });
            return null;
        } catch (Exception e) {
            downloadCallback.downloadError(processId, context.getString(R.string.msg_sorry_an_has_occurred));
            DebugLog.logD(TAG, "DOWNLOAD_EXCEPTION: " + e.toString());
            return null;
        }
    }


}
