package com.matio.seashell.utils;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * @author peilei on 2016/2/23.
 * @update yaomingzi
 */
public class TitleTabUtils {
//    public static void getTitleTab(TabLayout tabLayout, ViewPager vp, List<SubGame> list) {
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        //设置指示线消失
//        tabLayout.setSelectedTabIndicatorHeight(0);
//        for (int i = 0; i < list.size(); i++) {
//            View view = LayoutInflater.from(App.getInstance()).inflate(R.layout.item_tab_title, null);
//            TextView tv = (TextView) view.findViewById(R.id.tv_item_lottery_title);
//            tv.setText(list.get(i).getName());
//
//            RoundImageView img = (RoundImageView) view.findViewById(R.id.img_item_lottery_title);
//            x.image().bind(img, list.get(i).getImg_url(), new ImageOptions.Builder()
//                    .setLoadingDrawableId(R.mipmap.noimagesmall)
//                    .build());
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//            tab.setCustomView(view);
//        }
//        setListener(tabLayout, vp);
//    }
//
//    private static void setListener(TabLayout tablayout, final ViewPager vp) {
//        setViewBg(tablayout.getTabAt(0), true);
//        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                vp.setCurrentItem(tab.getPosition());
//                setViewBg(tab, true);
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                setViewBg(tab, false);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private static void setViewBg(TabLayout.Tab tab, boolean isSelect) {
//        View customView = tab.getCustomView();
//        View view = customView.findViewById(R.id.rel_tem_lottery_title_bg);
//        TextView name = (TextView) customView.findViewById(R.id.tv_item_lottery_title);
//        if (isSelect) {
//            name.setTextColor(App.getInstance().getResources().getColor(R.color.white));
//            view.setBackgroundResource(R.mipmap.ico_home_vod_game_choose);
//        } else {
//            name.setTextColor(App.getInstance().getResources().getColor(R.color.gray));
//            view.setBackground(null);
//        }
//    }
}
