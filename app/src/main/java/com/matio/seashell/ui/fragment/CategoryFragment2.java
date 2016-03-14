package com.matio.seashell.ui.fragment;

import com.matio.seashell.R;
import com.matio.seashell.adapter.HomeGridAdapter;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.common.CategoryConstant;
import com.matio.seashell.utils.xHttpUtils;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

/**
 * Created by Administrator on 2016/3/11.
 */
@ContentView(R.layout.fragment_category2)
public class CategoryFragment2 extends BaseFragment implements xHttpUtils.Callback{
    @ViewInject(R.id.gridview_fragment_caregory2)
    private GridViewWithHeaderAndFooter gridView;
    @ViewInject(R.id.srl_category2)
    private SwipyRefreshLayout srl;
    private CategoryGridAdapter adapter;
    private String urlEntity = "http://apicn.seashellmall.com/product/list/";
    private int page = 1;
    @Override
    public void requestNetData() {
        int id1 = getArguments().getInt("firstId");
        int id2 = getArguments().getInt("secondId");
        xHttpUtils.get(urlEntity+id1+"-"+id2+"?size=20&p="+page, this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String requestResult) {

    }
}
