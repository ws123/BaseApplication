package cc.carlos.application.IntentScrvice;

import android.app.IntentService;
import android.content.Intent;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import cc.carlos.application.BaseApplication;
import cc.carlos.application.Http.HttpClient;
import cc.carlos.application.Http.HttpRequestModel;


/**
 * Created by carlos on 15/7/7.
 */
public class HttpService extends IntentService {
    public static final String KEY_R_MODEL = "KEY_R_MODEL";

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public HttpService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
        final HttpRequestModel httpRequestModel = intent.getParcelableExtra(KEY_R_MODEL);
        switch (httpRequestModel.getRequest_type()) {
            case JSON:
                HttpClient.get(httpRequestModel.getUrl(), httpRequestModel.getRequestParams(), new JsonHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Intent intent_failure = new Intent();
                        intent_failure.setAction(httpRequestModel.getBroadcaseKey() + "f");
                        BaseApplication._instance.getLocalBroadcastManager().sendBroadcast(intent_failure);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                        Intent intent_success = new Intent();
                        intent.setAction(httpRequestModel.getBroadcaseKey());
                        intent_success.putExtra(httpRequestModel.getBroadcaseKey(), jsonObject.toString());
                        BaseApplication._instance.getLocalBroadcastManager().sendBroadcast(intent_success);
                    }
                });
                break;
            case UPLOAD:
                HttpClient.post(httpRequestModel.getUrl(), httpRequestModel.getRequestParams(), new JsonHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Intent intent_failure = new Intent();
                        intent_failure.setAction(httpRequestModel.getBroadcaseKey() + "f");
                        BaseApplication._instance.getLocalBroadcastManager().sendBroadcast(intent_failure);
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject jsonObject) {
                        Intent intent_success = new Intent();
                        intent.setAction(httpRequestModel.getBroadcaseKey());
                        intent_success.putExtra(httpRequestModel.getBroadcaseKey(), jsonObject.toString());
                        BaseApplication._instance.getLocalBroadcastManager().sendBroadcast(intent_success);
                    }
                });
                break;
        }
    }
}
