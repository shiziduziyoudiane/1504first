package com.matio.seashell.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseAppAdapter;
import com.matio.seashell.bean.category.CategoryList;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class CategoryListAdater extends BaseAppAdapter {


    public CategoryListAdater(Context context, List list, String mLeftOrRoght) {
        super(context, list, mLeftOrRoght);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {

        LeftViewHolder leftViewHolder = null;

        RightViewHolder rightViewHolder = null;

        if (convertView == null) {

            if (mLeftOrRight.equals("left")) {

                convertView = mInflater.inflate(R.layout.item_left_fragment_cateogory, parent, false);

                leftViewHolder = new LeftViewHolder(convertView);

                convertView.setTag(leftViewHolder);

            }

            if (mLeftOrRight.equals("right")) {

                convertView = mInflater.inflate(R.layout.item_right_fragment_cateogory, parent, false);

                rightViewHolder = new RightViewHolder(convertView);

                convertView.setTag(rightViewHolder);
            }

        } else {

            if (mLeftOrRight.equals("left")) {
                leftViewHolder = (LeftViewHolder) convertView.getTag();
            }

            if (mLeftOrRight.equals("right")) {
                rightViewHolder = (RightViewHolder) convertView.getTag();
            }

        }

        if (mLeftOrRight.equals("left")) {

            CategoryList.DataEntity.CategoriesEntity category = (CategoryList.DataEntity.CategoriesEntity) mList.get(position);

            if (category != null) {

                x.image().bind(leftViewHolder.iconImg, category.getIcon());

                leftViewHolder.nameTxt.setText(category.getName());
            }
        }
        if (mLeftOrRight.equals("right")) {

            CategoryList.DataEntity.CategoriesEntity.SubEntity sub = (CategoryList.DataEntity.CategoriesEntity.SubEntity) mList.get(position);

            if (sub != null) {

                x.image().bind(rightViewHolder.iconImg, sub.getIcon());

                rightViewHolder.nameTxt.setText(sub.getName());
            }
        }


        return convertView;
    }

    private class LeftViewHolder {

        @ViewInject(R.id.icon_left_item_fragment_category)
        public ImageView iconImg;

        @ViewInject(R.id.name_left_item_fragment_category)
        public TextView nameTxt;

        public LeftViewHolder(View view) {
            x.view().inject(this, view);
        }
    }

    public class RightViewHolder {

        @ViewInject(R.id.icon_right_item_fragment_category)
        public ImageView iconImg;

        @ViewInject(R.id.name_right_item_fragment_category)
        public TextView nameTxt;

        public RightViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}