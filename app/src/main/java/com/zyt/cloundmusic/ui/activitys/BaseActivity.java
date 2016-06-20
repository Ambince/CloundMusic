package com.zyt.cloundmusic.ui.activitys;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.zyt.cloundmusic.R;

/**
 * Created by Administrator on 2016/6/17.
 */
public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initAfterSetContentView(ContextCompat.getColor(this, R.color.theme_color));
    }

    @Override
    protected void onResume() {
        super.onResume();
        initAfterSetContentView(ContextCompat.getColor(this, R.color.theme_color));
    }

    //初始化完成后设置状态栏的颜色
    @TargetApi(Build.VERSION_CODES.KITKAT)
    protected void initAfterSetContentView(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        SystemBarTintManager tintManager;
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintColor(color);
        tintManager.setStatusBarTintEnabled(true);
    }
}
