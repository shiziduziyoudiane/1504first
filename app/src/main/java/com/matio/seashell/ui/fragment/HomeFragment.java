package com.matio.seashell.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSONObject;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.matio.seashell.R;
import com.matio.seashell.adapter.HomeGridAdapter;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.bean.home.HomeGrid;
import com.matio.seashell.common.HomeConstant;
import com.matio.seashell.ui.activity.HomeDetailActivity;
import com.matio.seashell.ui.activity.MainActivity;
import com.matio.seashell.ui.activity.SearchActivity;
import com.matio.seashell.utils.xHttpUtils;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

@ContentView(R.layout.fragment_home)
public class HomeFragment extends BaseFragment implements xHttpUtils.Callback,SwipyRefreshLayout.OnRefreshListener {

    @ViewInject(R.id.gridview_fragment_home)
    private GridViewWithHeaderAndFooter mGridView;  //第三方控件
    @ViewInject(R.id.srl_home)
    private SwipyRefreshLayout srl;

    private int page = 1;

    private HomeGridAdapter mHomeAdapter; //适配器

    private ArrayList<HomeGrid.DataEntity.ProductsEntity> mProductList = new ArrayList<>();//数据源

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void requestNetData() {
        xHttpUtils.get(HomeConstant.GRIDVIEW_URL_GET+page, this);
    }

    @Override
    public void initData() {

        //添加头部
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_gridview_home, null);

        mGridView.addHeaderView(headerView);

        srl.setOnRefreshListener(this);

    }

    @Override
    public void setAdapter() {

        mHomeAdapter = new HomeGridAdapter(getActivity(), mProductList);

        mGridView.setAdapter(mHomeAdapter);

    }


    @Event(value = {R.id.showslidingmenu_fragment_home, R.id.search_fragment_home})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.showslidingmenu_fragment_home:
                SlidingMenu slidingMenu = null;
                slidingMenu = ((MainActivity) getActivity()).getmSlidingMenu();
                slidingMenu.showMenu();
                break;
            case R.id.search_fragment_home:
                startActivity(new Intent(getActivity(), SearchActivity.class));

                break;
        }
    }


    @Override
    public void get(String requestResult) {

        HomeGrid homeGrid = JSONObject.parseObject(requestResult, HomeGrid.class);
        if (homeGrid != null) {

            mProductList.addAll(homeGrid.getData().getProducts());

            mHomeAdapter.notifyDataSetChanged();
        }
    }


    @Event(value = R.id.gridview_fragment_home, type = AdapterView.OnItemClickListener.class)
    private void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Intent intent = new Intent(getActivity(), HomeDetailActivity.class);
        if (mProductList != null) {
            intent.putExtra("id", mProductList.get(position).getId());
        }
        startActivity(intent);
    }

    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        switch(direction){
            case TOP:
                mProductList.clear();
                xHttpUtils.get(HomeConstant.GRIDVIEW_URL_GET+page, this);
                srl.setRefreshing(false);
                break;
            case BOTTOM:
                page++;
                xHttpUtils.get(HomeConstant.GRIDVIEW_URL_GET+page, this);
                srl.setRefreshing(false);
                break;
        }
    }

}