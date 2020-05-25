package com.wd.first.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;
import com.wd.first.R2;
import com.wd.first.fragment.DiseaseFragment;
import com.wd.first.fragment.DrugsFragment;
import com.wd.first.prenster.DepartmenPrenster;

import java.util.ArrayList;

import butterknife.BindView;

public class first_DepartmenActivity extends BaseActivity {
   @BindView(R2.id.tb)
    TabLayout tb;
   @BindView(R2.id.vp)
    ViewPager vp;
   private ArrayList<Fragment> list=new ArrayList<>();
    private ArrayList<String> tabs=new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_first__departmen;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        DiseaseFragment diseaseFragment = new DiseaseFragment();
        DrugsFragment drugsFragment = new DrugsFragment();
        list.add(diseaseFragment);
        list.add(drugsFragment);
        tabs.add("常见病状");
        tabs.add("常用药品");
        tb.addTab(tb.newTab().setText(tabs.get(0)));
        tb.addTab(tb.newTab().setText(tabs.get(1)));
        tb.setupWithViewPager(vp);
        first_MyAdapter adapter = new first_MyAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
    }
    class first_MyAdapter extends FragmentPagerAdapter {

        public first_MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }
    }
}
