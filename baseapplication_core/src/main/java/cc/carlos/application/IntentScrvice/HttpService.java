package cc.carlos.application.IntentScrvice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by zhangheilong on 15/7/7.
 */
public class HttpService extends IntentService{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public HttpService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
