package com.matio.seashell.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.matio.seashell.adapter.CategoryListAdater;
import com.matio.seashell.base.BaseFragment;
import com.matio.seashell.R;
import com.matio.seashell.bean.category.CategoryList;
import com.matio.seashell.common.CategoryConstant;
import com.matio.seashell.utils.xHttpUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.fragment_category)
public class CategoryFragment extends BaseFragment implements xHttpUtils.Callback {

    @ViewInject(R.id.left_listview_fragment_category)
    private ListView mLeftLv;

    @ViewInject(R.id.right_listview_fragment_category)
    private ListView mRightLv;
    private CategoryListAdater mLeftAdapter;

    private CategoryListAdater mRightAdapter;

    private ArrayList<CategoryList.DataEntity.CategoriesEntity> mCategorieList = new ArrayList<>(); //left数据源

    private ArrayList<CategoryList.DataEntity.CategoriesEntity.SubEntity> mSubList = new ArrayList<>();  //right数据源

    private int mWhichItem;

    private int id1;
    private int id2;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_catogery1, null);
//        mLeftLv = (ListView) view.findViewById(R.id.left_listview_fragment_category);
//        mRightLv = (ListView) view.findViewById(R.id.right_listview_fragment_category);
//        return view;
//    }

    @Override
    public void requestNetData() {

        xHttpUtils.get(CategoryConstant.LIST_URL_GET, this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void setAdapter() {
        mLeftAdapter = new CategoryListAdater(getActivity(), mCategorieList, "left");

        mLeftLv.setAdapter(mLeftAdapter);
        mLeftLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mWhichItem = position;
                for (int i = 0, size = mCategorieList.size(); i < size; i++) {
                    if (mWhichItem == i) {
                        mSubList.clear();
                        mSubList.addAll(mCategorieList.get(i).getSub());
                        id1 = mCategorieList.get(position).getId();
//                        TextView tv = (TextView) view.findViewById(R.id.name_left_item_fragment_category);
//                        tv.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                }
                mLeftAdapter.notifyDataSetChanged();
                mRightAdapter.notifyDataSetChanged();
            }
        });

        mRightAdapter = new CategoryListAdater(getActivity(), mSubList, "right");
        mRightLv.setAdapter(mRightAdapter);
        mRightLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fragment newFragment = newExampleFragment();
                id2 = mCategorieList.get(id1).getSub().get(position).getId();
                CategoryFragment2 fragment = new CategoryFragment2();
                Bundle bundle = new Bundle();
                bundle.putInt("firstId",id1);
                bundle.putInt("secondId",id2);
                fragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container_fragment_category, fragment);
                transaction.addToBackStack(null);
//提交修
                transaction.commit();
            }
        });

    }

    @Override
    public void get(String requestResult) {
        CategoryList category = JSONObject.parseObject(requestResult, CategoryList.class);
        if (category != null) {

            List<CategoryList.DataEntity.CategoriesEntity> categoriesEntityList = category.getData().getCategories();

            mCategorieList.addAll(categoriesEntityList);
            mSubList.clear();
            mSubList.addAll(mCategorieList.get(0).getSub());
            mLeftAdapter.notifyDataSetChanged();

            mRightAdapter.notifyDataSetChanged();
        }
    }


}
