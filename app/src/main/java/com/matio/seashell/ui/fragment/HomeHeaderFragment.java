package com.matio.seashell.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.matio.seashell.R;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.bean.home.HomeBanner;
import com.matio.seashell.common.HomeConstant;
import com.matio.seashell.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
@ContentView(R.layout.header_gridview_fragment_home)
public class HomeHeaderFragment extends BaseFragment implements xHttpUtils.Callback {


    @ViewInject(R.id.banner_header_fragment_home)
    private ConvenientBanner mAdBanner;

    private ArrayList<String> mImageList = new ArrayList<>();  //banner 数据源


    public static HomeHeaderFragment newInstance() {

        HomeHeaderFragment fragment = new HomeHeaderFragment();

        return fragment;
    }

    @Override
    public void requestNetData() {

        xHttpUtils.get(HomeConstant.BANNER_URL_GET, this);

    }

    @Override
    public void initData() {

        mAdBanner.setPages(new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        }, mImageList)

                //设置指示器图片
                .setPageIndicator(new int[]{R.mipmap.dot_blue, R.mipmap.dot_gray})

                        //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)

                .setManualPageable(true);
    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void get(String requestResult) {
        HomeBanner homeBanner = JSONObject.parseObject(requestResult, HomeBanner.class);
        if (homeBanner != null) {
            List<HomeBanner.DataEntity.Banners> bannersList = homeBanner.getData().getBanners();
            if (bannersList != null && bannersList.size() > 0) {

                for (HomeBanner.DataEntity.Banners banner : bannersList) {

                    mImageList.add(banner.getImage());
                }
                mAdBanner.notifyDataSetChanged();
            }
        }
    }


    public class LocalImageHolderView implements Holder<String> {

        private ImageView iconImg;

        @Override
        public View createView(Context context) {
            iconImg = new ImageView(context);
            iconImg.setScaleType(ImageView.ScaleType.FIT_XY);
            return iconImg;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            x.image().bind(iconImg, data);
        }
    }
}
