package com.matio.seashell.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Angel on 2016/3/8.
 */
public class SdCardCache extends ThreeLevelCache {

    private File file;

    public SdCardCache(Context context) {
        //判断sdcard是否存在 并且该应用程序拥有读写该sdcard的能力
        if (isSdCard()) {
            file = context.getExternalCacheDir();
        }
    }

    /**
     * 从缓存中获取图片
     *
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = null;
        //截取文件名
        String fileName = getFileName(url);
        File newFile = new File(file, fileName);
        if (newFile.exists()) {
            bitmap = BitmapFactory.decodeFile(newFile.getAbsolutePath());
        }
        return bitmap;
    }

    /**
     * @param url
     * @return
     */
    private String getFileName(String url) {
        return url.substring(url.lastIndexOf('/') + 1, url.length());
    }

    private boolean isSdCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 存储图片
     *
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        String fileName = getFileName(url);
        FileOutputStream fileOutputStream = null;
        try {
            //获取文件输出流
            fileOutputStream = new FileOutputStream(new File(file, fileName));
            //参数一  图片压缩的格式
            //参数二  quality
            //参数三  输出流
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
