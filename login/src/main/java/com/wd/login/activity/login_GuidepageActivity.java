package com.wd.login.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.stx.xhb.xbanner.XBanner;
import com.wd.login.R;

import java.util.ArrayList;

import butterknife.BindView;

public class login_GuidepageActivity extends AppCompatActivity {

    private XBanner xb;
    ArrayList<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__guidepage);
        xb = findViewById(R.id.login_xb);
        list.add(R.mipmap.login_guidepage2);
        list.add(R.mipmap.login_guidepage3);
        list.add(R.mipmap.login_guidepage4);
        list.add(R.mipmap.login_guidepage5);
        xb.setData(list,null);
        xb.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageView iv= (ImageView) view;
                iv.setImageResource(list.get(position));

            }
        });


    }
}
