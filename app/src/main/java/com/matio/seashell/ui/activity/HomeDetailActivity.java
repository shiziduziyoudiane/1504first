package com.matio.seashell.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.matio.seashell.R;
import com.matio.seashell.base.BaseActivity;
import com.matio.seashell.ui.fragment.HomeDetailFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;

/**
 * Created by Angel on 2016/3/8.
 */
@ContentView(R.layout.activity_detail_home)
public class HomeDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_activity_detail_home, HomeDetailFragment.newInstance(intent.getIntExtra("id", 0)))
                    .commit();
        }

    }


    @Event(value = {R.id.back_activity_detail_home, R.id.cartpic_activity_detail_home, R.id.carttxt_activity_detail_home, R.id.share_activity_detail_home})
    private void onClick(View view) {

        switch (view.getId()) {

            case R.id.back_activity_detail_home:
                finish();
                break;


            case R.id.share_activity_detail_home:
                break;


            case R.id.cartpic_activity_detail_home:
                break;


            case R.id.carttxt_activity_detail_home:
                break;
        }
    }
}
