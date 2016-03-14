package com.matio.seashell.utils;

import android.util.Log;
import android.widget.ImageView;

import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by Angel on 2016/3/8.
 */
public class xHttpUtils {

    private RequestMode mRequestMode;


    /**
     * get
     *
     * @param url
     * @param callback
     */
    public static void get(String url, final Callback callback) {
        x.http().get(new RequestParams(url), new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    callback.get(result);
                } else {
                    Log.i(LogUtils.TAG, "onSuccess --result" + result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onError");
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onCancelled");
                }
            }

            @Override
            public void onFinished() {
                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onFinished");
                }
            }
        });
    }

    public interface Callback {
        void get(String requestResult);
    }


    /**
     * post
     *
     * @param requestParams
     * @param callback
     */
    public static void post(RequestParams requestParams, final Callback callback) {
        x.http().post(requestParams, new org.xutils.common.Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    callback.get(result);
                } else {
                    Log.i(LogUtils.TAG, "onSuccess --result" + result);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onError");
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {
                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onCancelled");
                }
            }

            @Override
            public void onFinished() {
                if (LogUtils.isLog) {
                    Log.i(LogUtils.TAG, "onFinished");
                }
            }
        });
    }


    /**
     * picture
     *
     * @param url
     * @param imageView
     * @param options
     */
    public static void getImage(String url, ImageView imageView, ImageOptions options) {
        x.image().bind(imageView, url, options);
    }
    public static void getImage(String url, ImageView imageView) {
        x.image().bind(imageView, url);
    }
}
