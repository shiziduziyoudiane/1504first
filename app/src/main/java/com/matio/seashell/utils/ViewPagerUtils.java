package com.matio.seashell.utils;

import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Angel on 2016/3/7.
 */
public class ViewPagerUtils {


    public static void setAdapter(ViewPager viewPager, final List<View> viewList) {

//        if (viewPager != null) {
//            viewPager.setAdapter(new PagerAdapter() {
//                @Override
//                public int getCount() {
//                    return viewList != null ? viewList.size() : 0;
//                }
//
//                @Override
//                public boolean isViewFromObject(View view, Object object) {
//                    return view == (View) object;
//                }
//
//                @Override
//                public Object instantiateItem(ViewGroup container, int position) {
//
//                    View view = viewList.get(position);
//                    container.addView(view);
//                    return view;
//                }
//
//                @Override
//                public void destroyItem(ViewGroup container, int position, Object object) {
//                    container.removeView(viewList.get(position));
//                }
//            });
//        } else {
//            if (LogUtils.isLog) {
//                Log.i(LogUtils.TAG, "-----------------viewpager = null-----------------");
//            }
//        }
    }
}
