package cc.carlos.application;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;

import java.util.HashMap;

import cc.carlos.application.exception.BaseAppException;

/**
 * Created by zhangheilong on 15/5/28.
 */
public class BaseApplication extends Application {
    //用来存储数据
    private HashMap<String, Object> hash;
    //单例
    public static BaseApplication _instance;
    //用来发送应用内的广播，比使用全局广播效率更高
    private LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = (BaseApplication) getApplicationContext();
    }

    /**
     * 此方法的目的是为了在界面跳转的时候，保存数据对象
     *
     * @param key    要保存的object的key，建议使用 object.class.getName()作为key
     * @param object 要保存的对象
     */
    public void saveObject(String key, Object object) {
        if (hash == null) {
            hash = new HashMap<>();
        }
        hash.put(key, object);
    }

    /**
     * @param key 要获取的对象的key
     * @return 返回要获取的对象，如果对象不存大，就抛出异常
     */
    public Object getObject(String key) {
        if (hash == null) {
            hash = new HashMap<>();
            throw new BaseAppException("你要获取的对象不存在");
        }
        if (hash.containsKey(key)) {
            return hash.get(key);
        } else {
            throw new BaseAppException("你要获取的对象不存在");
        }
    }

    /**
     * 删除没有用的对象，一般对象取出以后，就应该删除
     *
     * @param key 要删除的对象的key
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
     * 用来获取发送广播的发布器
     *
     * @return 一个广播的发布器
     */
    public LocalBroadcastManager getLocalBroadcastManager() {
        if (localBroadcastManager == null) {
            localBroadcastManager = LocalBroadcastManager.getInstance(_instance);
        }
        return localBroadcastManager;
    }
}
