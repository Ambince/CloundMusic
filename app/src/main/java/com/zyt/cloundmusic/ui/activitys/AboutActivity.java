package com.zyt.cloundmusic.ui.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zyt.cloundmusic.R;

/**
 * Created by Administrator on 2016/6/17.
 */
public class AboutActivity extends ToolbarActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initToolBar(true);
    }

    @Override
    public String returnToolBarTitle() {
        return "关于";
    }
}
