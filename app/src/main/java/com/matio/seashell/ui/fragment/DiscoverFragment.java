package com.matio.seashell.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.matio.seashell.R;
import com.matio.seashell.adapter.DiscoverListAdapter;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.bean.discover.DiscoverList;
import com.matio.seashell.common.DiscoverConstant;
import com.matio.seashell.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

@ContentView(R.layout.fragment_discover)
public class DiscoverFragment extends BaseFragment implements xHttpUtils.Callback {


    @ViewInject(R.id.listview_fragment_discover)
    private ListView mDiscoverLv;  //listview

    private DiscoverListAdapter mDiscoverAdapter;  //适配器

    private ArrayList<DiscoverList.DataEntity.TopicsEntity> mTopicList = new ArrayList<>(); //数据源

    public static DiscoverFragment newInstance() {
        DiscoverFragment fragment = new DiscoverFragment();
        return fragment;
    }


    @Override
    public void requestNetData() {

        xHttpUtils.get(DiscoverConstant.LIST_URL_GET, this);

    }

    @Override
    public void initData() {


    }

    @Override
    public void setAdapter() {
        mDiscoverAdapter = new DiscoverListAdapter(getActivity(), mTopicList);
        mDiscoverLv.setAdapter(mDiscoverAdapter);

    }

    @Override
    public void get(String requestResult) {
        DiscoverList discover = JSONObject.parseObject(requestResult, DiscoverList.class);

        if (discover != null) {
            mTopicList.addAll(discover.getData().getTopics());
            mDiscoverAdapter.notifyDataSetChanged();
        }
    }
}
