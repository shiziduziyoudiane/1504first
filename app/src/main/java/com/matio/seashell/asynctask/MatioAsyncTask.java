package com.matio.seashell.asynctask;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Angel on 2016/3/7.
 */
public class MatioAsyncTask extends AsyncTask<String, Void, byte[]> {

    private Context mContext;

    private String mUrlPostParameter;

    private ImageView mIconImg;

    private Callback mCallback;


    /**
     * @param mContext
     * @param mUrlPostParameter
     * @param mIconImg
     * @param mCallback
     */
    public MatioAsyncTask(Context mContext, String mUrlPostParameter, ImageView mIconImg, Callback mCallback) {
        this.mContext = mContext;
        this.mUrlPostParameter = mUrlPostParameter;
        this.mIconImg = mIconImg;
        this.mCallback = mCallback;
    }


    /**
     * get
     *
     * @param context
     * @param callback
     */
    public MatioAsyncTask(Context context, Callback callback) {
        this(context, null, null, callback);
        this.mContext = context;
        this.mCallback = callback;
    }


    /**
     * post
     *
     * @param context
     * @param urlPostParameter
     * @param callback
     */
    public MatioAsyncTask(Context context, String urlPostParameter, Callback callback) {
        this(context, urlPostParameter, null, callback);
        this.mContext = context;
        this.mUrlPostParameter = urlPostParameter;
        this.mCallback = callback;
    }


    /**
     * picture
     *
     * @param context
     * @param imageView
     */
    public MatioAsyncTask(Context context, ImageView imageView) {
        this(context, null, imageView, null);
        this.mContext = context;
        this.mIconImg = imageView;
    }


    @Override
    protected byte[] doInBackground(String... params) {
        if (isNetConnected(mContext)) {
            if (params != null) {
                byte[] result = requestNetByGetOrPost(params[0], mUrlPostParameter);
                if (result != null && result.length > 0) {
                    return result;
                }
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);

        if (bytes != null && bytes.length > 0) {
            if (mIconImg != null) {

                mIconImg.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));

            } else {
                mCallback.getResponseData(new String(bytes, 0, bytes.length));
            }
        }

    }


    /**
     * interface to callback
     */
    public interface Callback {
        void getResponseData(String result);
    }


    /**
     * 判断网络是否连接成功
     *
     * @param context 上下文对象
     * @return
     */
    public static boolean isNetConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        return info.isConnected();
    }

    /**
     * 请求网络请求
     *
     * @param urlPath      url地址
     * @param urlParameter url请求参数
     * @return 字节数组
     */
    public static byte[] requestNetByGetOrPost(String urlPath, String urlParameter) {

        HttpURLConnection connection = null;

        InputStream is = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            URL url = new URL(urlPath);

            connection = (HttpURLConnection) url.openConnection();

            if (urlParameter != null) {

                connection.setDoInput(true);

                connection.setDoOutput(true);
                //设置请求方式为post
                connection.setRequestMethod("POST");

                connection.getOutputStream().write(urlParameter.getBytes());

                connection.getOutputStream().flush();

                connection.getOutputStream().close();
            }
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                is = connection.getInputStream();

                int len = 0;

                byte[] buf = new byte[1024];

                while ((len = is.read(buf)) != -1) {

                    baos.write(buf, 0, len);
                }
                baos.flush();
                if (baos != null) {

                    return baos.toByteArray();
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {

                if (baos != null) {
                    baos.close();

                }

                if (is != null) {
                    is.close();
                }

                if (connection != null) {
                    connection.disconnect();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public Callback getmCallback() {
        return mCallback;
    }

    public void setmCallback(Callback mCallback) {
        this.mCallback = mCallback;
    }
}
