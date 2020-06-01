package com.wd.login.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wd.login.R;
import com.wd.login.R2;

import butterknife.BindView;

/**
 * 引导页开始
 */
public class login_FiringActivity extends AppCompatActivity {
//@BindView(R2.id.firing_iv)
//ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__firing);
       ImageView iv= findViewById(R.id.firing_iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_FiringActivity.this, login_GuidepageActivity.class);
                startActivity(intent);
            }
        });
    }
}
