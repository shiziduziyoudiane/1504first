package com.matio.seashell.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseAppAdapter;
import com.matio.seashell.bean.discover.DiscoverList;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Angel on 2016/3/8.
 */
public class DiscoverListAdapter extends BaseAppAdapter {

    public DiscoverListAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview_fragment_discover, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mList != null) {
            DiscoverList.DataEntity.TopicsEntity topic = (DiscoverList.DataEntity.TopicsEntity) mList.get(position);

            if (topic != null) {
                x.image().bind(viewHolder.iconImg, topic.getImage());
                viewHolder.nameTxt.setText(topic.getTitle());
            }
        }

        return convertView;
    }

    private class ViewHolder {

        @ViewInject(R.id.icon_item_fragment_discover)
        public ImageView iconImg;

        @ViewInject(R.id.name_item_fragment_discover)
        public TextView nameTxt;

        public ViewHolder(View view) {
            x.view().inject(this, view);
        }
    }
}
