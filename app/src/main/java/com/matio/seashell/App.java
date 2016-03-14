package com.matio.seashell;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Angel on 2016/3/7.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
