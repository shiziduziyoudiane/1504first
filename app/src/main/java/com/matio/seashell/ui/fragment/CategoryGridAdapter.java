package com.matio.seashell.ui.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseAppAdapter;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14.
 */
public class CategoryGridAdapter extends BaseAppAdapter {
    public CategoryGridAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        return null;
    }
    private class ViewHolder{
//        @ViewInject(R.id.discount_item_fragment_category2)
    }
}
