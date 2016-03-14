package com.matio.seashell.ui.fragment;

import android.os.Bundle;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseFragment;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Angel on 2016/3/9.
 */

@ContentView(R.layout.fragment_help)
public class HelpFragment extends BaseFragment {

    public static HelpFragment newInstance() {

        Bundle args = new Bundle();

        HelpFragment fragment = new HelpFragment();
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
