package cc.carlos.application;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;

import java.util.HashMap;

import cc.carlos.application.exception.BaseAppException;

/**
 * Created by zhangheilong on 15/5/28.
 */
public class BaseApplication extends Application {
    //to save object data
    private HashMap<String, Object> hash;
    //single
    public static BaseApplication _instance;

    private LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = (BaseApplication) getApplicationContext();
    }

    /**
     * to save object data during fragment exchange
     *
     * @param key    the key of object data,suggest to use object.class.getName()
     * @param object the object to save
     */
    public void saveObject(String key, Object object) {
        if (hash == null) {
            hash = new HashMap<>();
        }
        hash.put(key, object);
    }

    /**
     * @param key the key of object which you are trying to get
     * @return the object to return,if it's not exist,return exception
     */
    public Object getObject(String key) {
        if (hash == null) {
            hash = new HashMap<>();
            throw new BaseAppException("the object doesn't exist");
        }
        if (hash.containsKey(key)) {
            return hash.get(key);
        } else {
            throw new BaseAppException("the object doesn't exist");
        }
    }

    /**
     * remove object from hashmap
     *
     * @param key the key of object which you are trying to remove
     */
    public void removeObject(String key) {
        if (hash == null) {
            return;
        }
        if (hash.containsKey(key)) {
            hash.remove(key);
        } else {
            return;
        }
    }

    /**
     * to get a BroadcastManager
     *
     * @return a BroadcastManager
     */
    public LocalBroadcastManager getLocalBroadcastManager() {
        if (localBroadcastManager == null) {
            localBroadcastManager = LocalBroadcastManager.getInstance(_instance);
        }
        return localBroadcastManager;
    }
}
