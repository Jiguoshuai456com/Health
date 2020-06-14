package com.wd.first.fragment;

import android.view.View;

import com.wd.common.Base.BaseFragment;
import com.wd.common.Base.BasePresenter;
import com.wd.first.R;

public class Movie_Fragment extends BaseFragment {
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.adapter_play_video;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }
}
