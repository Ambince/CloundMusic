package com.zyt.cloundmusic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zyt.cloundmusic.R;
import com.zyt.cloundmusic.ui.activitys.MainActivity;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2016/6/15.
 */
public class Fragment1 extends Fragment {


    @Bind(R.id.viewpager_child)
    ViewPager viewpagerChild;

    @Bind(R.id.tablayout_child)
    TabLayout tablayoutChild;

    @BindColor(R.color.theme_color)
    int themeColor;
    @BindColor(R.color.textColorGray)
    int textColorGray;

    String String[] = {"个性推荐", "歌单", "主播电台", "排行版"};
    private int mTabCount = 4;


    //启动Fragment1时，将需求留出的空间大小作为参数
    public static final Fragment1 newInstance(int size) {
        Fragment1 fragment = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt(Fragment1.class.getName(), size);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.fragment1, container, false);
        ButterKnife.bind(this, view);
     //   MainActivity parentActivity = (MainActivity ) getActivity();

        int MarginsSize = getArguments().getInt(Fragment1.class.getName());
        Log.e("MarginsSize",MarginsSize+"");
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tablayoutChild.getLayoutParams();
        layoutParams.setMargins(0, MarginsSize, 0, 0);


        viewpagerChild.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return new TestFragment();
            }

            @Override
            public int getCount() {
                return mTabCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return String[position];
            }
        });
        tablayoutChild.setupWithViewPager(viewpagerChild);
        return view;
    }

    //获取状态栏高度
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
