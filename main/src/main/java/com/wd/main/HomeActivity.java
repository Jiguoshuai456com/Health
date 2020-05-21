package com.wd.main;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.androidkun.xtablayout.XTabLayout;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.main.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;


@Route(path = "/homepage/HomePageActivity")
public class HomeActivity extends BaseActivity {
    private ViewPager vp;
    private XTabLayout tab;
    private List<Fragment>fragmentList = new ArrayList<>();
    private List<String>list = new ArrayList<>();
    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (XTabLayout) findViewById(R.id.tab);
        fragmentList.add(new HomeFragment());
        list.add("首页");
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initData() {

    }
}
