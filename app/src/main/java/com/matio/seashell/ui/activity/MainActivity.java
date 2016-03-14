package com.matio.seashell.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.matio.seashell.R;
import com.matio.seashell.base.BaseActivity;
import com.matio.seashell.ui.fragment.CategoryFragment;
import com.matio.seashell.ui.fragment.DiscoverFragment;
import com.matio.seashell.ui.fragment.HelpFragment;
import com.matio.seashell.ui.fragment.HomeFragment;
import com.matio.seashell.ui.fragment.OrderFragment;
import com.matio.seashell.ui.fragment.SettingFragment;
import com.matio.seashell.utils.FragmentUtils;

import org.xutils.view.annotation.ContentView;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements FragmentUtils.OnRgsExtraCheckedChangedListener {

    private SlidingMenu mSlidingMenu;

    private RadioGroup mRag;

    public SlidingMenu getmSlidingMenu() {
        return mSlidingMenu;
    }

    private ViewCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置策划菜单
        setSlidingMenu();

        //fragment选择
        setFragment();
    }

    /**
     * fragment选择
     */
    private void setFragment() {

        ArrayList<Fragment> fragmentList = new ArrayList<>();

        fragmentList.add(HomeFragment.newInstance());

        fragmentList.add(DiscoverFragment.newInstance());

        fragmentList.add(CategoryFragment.newInstance());

        fragmentList.add(OrderFragment.newInstance());

        fragmentList.add(SettingFragment.newInstance());

        fragmentList.add(HelpFragment.newInstance());

        new FragmentUtils(getSupportFragmentManager(), fragmentList, R.id.container_activity_main, mRag, mSlidingMenu, this);
    }


    /**
     * 设置策划菜单
     */
    private void setSlidingMenu() {

        mSlidingMenu = new SlidingMenu(this);

        mSlidingMenu.setMode(SlidingMenu.LEFT);

        // 设置触摸屏幕的模式
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

        //   mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);

        //   mSlidingMenu.setShadowDrawable(R.drawable.shadow);

        // 设置滑动菜单视图的宽度
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

        // 设置渐入渐出效果的值
        mSlidingMenu.setFadeDegree(0.35f);

        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);


        //加载布局
        View slidingMenuView = LayoutInflater.from(this).inflate(R.layout.slidingmenu_activity_main, null);

        mRag = (RadioGroup) slidingMenuView.findViewById(R.id.radiogroup_slidingmenu_activity_main);

        //为侧滑菜单设置布局
        mSlidingMenu.setMenu(slidingMenuView);
//
    }

    @Override
    public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
    }


    public interface ViewCallback{
        void click(SlidingMenu slidingMenu);
    }
}