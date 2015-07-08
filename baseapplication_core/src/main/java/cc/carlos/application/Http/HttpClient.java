package cc.carlos.application.Http;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by carlos on 15/7/8.
 */
public class HttpClient {
    public static final HttpClient httpClient = new HttpClient();


    public static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        httpClient.get(url, params, responseHandler);
    }

    public static void post(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
        httpClient.post(url, params, responseHandler);
    }

}
