package com.example.bovink.commonutil.util;

import android.util.Log;

/**
 * Log工具类
 *
 * @author bovink
 * @since 2016/6/15
 */
public class LogUtil {
    /**
     * Log开关
     */
    public static boolean isDebug = true;
    /**
     * 默认tag
     */
    private final static String TAG = "LogUtil";

    private LogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * info
     *
     * @param tag tag
     * @param msg msg
     */
    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    /**
     * info
     *
     * @param msg msg
     */
    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    /**
     * debug
     *
     * @param tag tag
     * @param msg msg
     */
    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    /**
     * debug
     *
     * @param msg msg
     */
    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    /**
     * error
     *
     * @param tag tag
     * @param msg msg
     */
    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    /**
     * error
     *
     * @param msg msg
     */
    public static void e(String msg) {
        Log.e(TAG, msg);
    }

    /**
     * verbose
     *
     * @param tag tag
     * @param msg msg
     */
    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    /**
     * verbose
     *
     * @param msg msg
     */
    public static void v(String msg) {
        Log.v(TAG, msg);
    }

    /**
     * warn
     *
     * @param tag tag
     * @param msg msg
     */
    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    /**
     * warn
     *
     * @param msg msg
     */
    public static void w(String msg) {
        Log.w(TAG, msg);
    }
}
