package com.matio.seashell.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.matio.seashell.R;
import com.matio.seashell.adapter.MyPagerAdapter;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.bean.home.HomeDetail;
import com.matio.seashell.common.HomeConstant;
import com.matio.seashell.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
@ContentView(R.layout.fragment_home_detail)
public class HomeDetailFragment extends BaseFragment implements xHttpUtils.Callback {

    @ViewInject(R.id.banner_fragment_home_detail)
    private ConvenientBanner mBanner; //banner
    @ViewInject(R.id.tab_home_detail_bottom)
    private TabLayout tabLayout;
    @ViewInject(R.id.vp_home_detail_bottom)
    private ViewPager viewPager;
    private HomeDetail.DataEntity.ProductEntity mProduct;
    private List<String>titles = new ArrayList<>();
    private MyPagerAdapter mypagerAdapter;
    private List<View>mViewList = new ArrayList<>();

    public static HomeDetailFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id", id);
        HomeDetailFragment fragment = new HomeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void requestNetData() {

        xHttpUtils.get(getUrl(), this);

    }

    @Override
    public void initData() {


    }

    @Override
    public void setAdapter() {
        titles.add("商品详情");
        titles.add("其他信息");
        mypagerAdapter = new MyPagerAdapter(mViewList,titles);
        viewPager.setAdapter(mypagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabsFromPagerAdapter(mypagerAdapter );
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
    }


    @Override
    public void get(String requestResult) {

        HomeDetail homeDetail = JSONObject.parseObject(requestResult, HomeDetail.class);

        if (homeDetail != null) {

            HomeDetail.DataEntity.ProductEntity product = homeDetail.getData().getProduct();

            if (product != null) {
                mProduct = product;
                List<HomeDetail.DataEntity.ProductEntity.ImagesEntity> imageViews = new ArrayList<>();
                View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_detail_pager1,null);
                TextView textView = (TextView) view1.findViewById(R.id.tv_detail);
                textView.setText(mProduct.getDesc());
                View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_detail_pager2,null);
                getView2(view2);
                mViewList.add(view1);
                mViewList.add(view2);
                mypagerAdapter.notifyDataSetChanged();
                imageViews.clear();
                imageViews.addAll(mProduct.getImages());
                mBanner.setPages(
                        new CBViewHolderCreator<MyImageHolderView>() {
                            @Override
                            public MyImageHolderView createHolder() {
                                return new MyImageHolderView();
                            }
                        }, imageViews).setPageIndicator(new int[]{R.mipmap.dot_gray, R.mipmap.dot_blue})
                        //设置指示器的方向
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT).
                        setManualPageable(true);
                mBanner.startTurning(3000);
                //设置翻页的效果，不需要翻页效果可用不设
            }

        }
    }

    private void getView2(View view2) {
        TextView textView1 = (TextView) view2.findViewById(R.id.tv_home_detail_location);
        textView1.setText(mProduct.getLocation());
        TextView textView2 = (TextView) view2.findViewById(R.id.tv_home_detail_merchant_name);
        textView2.setText(mProduct.getMerchant().getName());
        TextView textView3 = (TextView) view2.findViewById(R.id.tv_home_detail_name);
        textView3.setText(mProduct.getName());
        TextView textView4 = (TextView) view2.findViewById(R.id.tv_home_detail_fav_count);
        textView4.setText(mProduct.getFav_count());
        RatingBar ratingBar1 = (RatingBar) view2.findViewById(R.id.rb_home_detail_shopscore);
        ratingBar1.setProgress(Integer.parseInt(mProduct.getMerchant().getScore()));
        ratingBar1.setStepSize((float)0.5);
        RatingBar ratingBar2 = (RatingBar) view2.findViewById(R.id.rb_home_detail_goodScore);
        ratingBar2.setProgress(Integer.parseInt(mProduct.getScore()));
        ratingBar2.setStepSize((float)0.5);
    }


    /**
     * 获取完整的url
     *
     * @return
     */
    private String getUrl() {
        if (getArguments() != null) {
            return HomeConstant.ITEM_URL_GET + getArguments().getInt("id");
        }

        return null;
    }

    public class MyImageHolderView implements Holder<HomeDetail.DataEntity.ProductEntity.ImagesEntity> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, HomeDetail.DataEntity.ProductEntity.ImagesEntity data) {
            xHttpUtils.getImage(mProduct.getImages().get(position).getUrl(), imageView);
        }

    }
}
