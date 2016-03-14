package com.matio.seashell.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by Angel on 2016/3/7.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        requestNetData();


        initData();


        setAdapter();
    }

    /**
     * 请求网络
     */
    public abstract void requestNetData();

    /**
     * 初始化
     */
    public abstract void initData();

    /**
     * 设置适配器
     */
    public abstract void setAdapter();
}
