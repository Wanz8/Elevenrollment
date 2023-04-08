package business;



import android.content.Context;
import android.content.SharedPreferences;


import java.util.Map;

import application.MyApplication;

/**
 * Save information settings
 */
public class SharedPreferencesHelper {
    private SharedPreferences sharedPreferences;
    /*
     * 保存手机里面的名字
     */private SharedPreferences.Editor editor;

    public SharedPreferencesHelper() {
        sharedPreferences = MyApplication.getContext().getSharedPreferences("Data1",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * Storage
     */
    public void put(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
        editor.commit();
    }

    /**
     * Get saved data
     */
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }

    /**
     * Remove a key value that already corresponds to a value
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * Remove all datas
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * Query whether a key exists
     */
    public Boolean contain(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * Returns all key-value pairs
     */
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }
}
