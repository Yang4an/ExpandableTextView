package com.yang4an.library;

import android.util.Log;

public class LogUtil {
    public static void d(String tag, String log) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, log);
        }
    }
}
