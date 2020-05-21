package com.wd.main.fragment;
/*
 *@auther:段海涛
 *@Date: 2020-05-21
 *@Time:20:09
 *@Description:${DESCRIPTION}
 **/

import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.navigation.NavigationView;
import com.wd.common.Base.BaseFragment;
import com.wd.common.Base.BasePresenter;
import com.wd.main.R;

public class HomeFragment extends BaseFragment {


    private DrawerLayout drawerLayout;
    private SimpleDraweeView svdImage;
    private NavigationView navigationView;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        svdImage = (SimpleDraweeView) view.findViewById(R.id.svd_image);
        navigationView = (NavigationView) view.findViewById(R.id.navigation_view);

    }

    @Override
    protected void initData() {
        navigationView.getHeaderView(0);
        svdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);

                }else{
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });
    }
}
