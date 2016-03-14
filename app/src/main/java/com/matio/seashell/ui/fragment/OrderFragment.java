package com.matio.seashell.ui.fragment;

import android.os.Bundle;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Angel on 2016/3/9.
 */
@ContentView(R.layout.fragment_orders)
public class OrderFragment extends BaseFragment {

    public static OrderFragment newInstance() {
        
        Bundle args = new Bundle();
        
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void requestNetData() {
        
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }
}
