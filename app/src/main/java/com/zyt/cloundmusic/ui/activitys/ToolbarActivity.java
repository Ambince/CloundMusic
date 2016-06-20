package com.zyt.cloundmusic.ui.activitys;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zyt.cloundmusic.R;

/**
 * Created by Administrator on 2016/6/17.
 */
public abstract class ToolbarActivity extends BaseActivity{

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle(returnToolBarTitle());
    }

    //初始化toolbar
    protected void initToolBar(Boolean isShowBack) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.textColorWhite));

          //设置返回箭头
            getSupportActionBar().setDisplayHomeAsUpEnabled(isShowBack);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

    }



    public abstract String returnToolBarTitle();
}
