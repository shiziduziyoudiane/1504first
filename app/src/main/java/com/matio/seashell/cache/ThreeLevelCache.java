package com.matio.seashell.cache;

import android.graphics.Bitmap;

/**
 * Created by Angel on 2016/3/8.
 */
public abstract class ThreeLevelCache {


    /**
     * 获取  图片
     *
     * @param url url地址
     * @return
     */
    abstract Bitmap get(String url);


    /**
     * 存储图片
     *
     * @param url    url地址
     * @param bitmap
     */
    abstract void put(String url, Bitmap bitmap);


}
