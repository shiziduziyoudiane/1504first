package com.matio.seashell.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseAppAdapter;
import com.matio.seashell.bean.home.HomeGrid;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/7.
 */
public class HomeGridAdapter extends BaseAppAdapter {

    public HomeGridAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gridview_fragment_home, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            HomeGrid.DataEntity.ProductsEntity product = (HomeGrid.DataEntity.ProductsEntity) mList.get(position);

            if (product != null) {

                x.image().bind(viewHolder.iconImg, product.getImages().get(0).getUrl());

                HomeGrid.DataEntity.ProductsEntity.CurrentSkuEntity current_sku = product.getCurrent_sku();

                if (current_sku != null) {

                    viewHolder.priceTxt.setText(current_sku.getReal_price().getCNY() + "");

                    viewHolder.discountTxt.setText((100 - current_sku.getDiscount()) / 10+"");
                }
            }
        }

        return convertView;
    }

    private class ViewHolder {

        @ViewInject(R.id.icon_item_fragment_home)
        public ImageView iconImg;

        @ViewInject(R.id.price_item_fragment_home)
        public TextView priceTxt;

        @ViewInject(R.id.discount_item_fragment_home)
        public TextView discountTxt;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }

}
