package com.matio.seashell.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Angel on 2016/3/8.
 */
public class MemoryCache extends ThreeLevelCache {

    private LruCache<String, Bitmap> mLruCache;

    public static final int MEMORY_SIZE = (int) Runtime.getRuntime().maxMemory();


    public static MemoryCache getInstance() {
        return new MemoryCache();
    }


    private MemoryCache() {

        if (mLruCache == null) {
            mLruCache = new LruCache<String, Bitmap>(MEMORY_SIZE / 8 / 1024) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight() / 1024;
                }
            };
        }

    }


    @Override
    Bitmap get(String url) {
        if (url != null) {
            return mLruCache.get(url);
        }
        return null;
    }

    @Override
    void put(String url, Bitmap bitmap) {

        if (get(url) != null && bitmap != null) {
            mLruCache.put(url, bitmap);
        }

    }
}
