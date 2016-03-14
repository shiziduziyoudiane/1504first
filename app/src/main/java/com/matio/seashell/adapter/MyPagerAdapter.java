package com.matio.seashell.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/3/11.
 */
public class MyPagerAdapter extends PagerAdapter{
    private List<View>mViewLists;
    private List<String>titles;

    public MyPagerAdapter (List<View>mViewLists,List<String>titles){
        this.mViewLists = mViewLists;
        this.titles = titles;
    }
    @Override
    public int getCount() {
        return mViewLists.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewLists.get(position));
        return mViewLists.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewLists.get(position));//删除页卡
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);//页卡标题
    }
}
