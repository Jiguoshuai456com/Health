package com.wd.login.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.stx.xhb.xbanner.XBanner;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.login.R;
import com.wd.login.R2;
import com.wd.login.adapter.GuideAdapter;
import com.wd.login.login_LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 引导页
 */
public class login_GuidepageActivity extends BaseActivity {
    private ViewPager vp;
    private LinearLayout ll;
    private View vw;
    private TextView tv;
    private int disPoints;
    private int currentItem;
    private String[] s=new String[]{"专业的在线问诊","丰富的健康常识","专业的在线问诊","丰富的健康常识","打造你的健康"};
private int[] mPics = new int[]{R.mipmap.guide_pages_one, R.mipmap.guide_pages_two, R.mipmap.guide_pages_three, R.mipmap.guide_pages_four, R.mipmap.guide_pages_five};
    private ArrayList<ImageView> guids;
    private GuideAdapter guideAdapter;
    private Button bt;

    @Override
    protected int getLayout() {
        return R.layout.activity_login__guidepage;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.guide_vp);
        tv = findViewById(R.id.guide_tv);
        ll = findViewById(R.id.guide_ll);
        vw = findViewById(R.id.guide_vw);
        bt = findViewById(R.id.guide_bt);
        //隐藏按钮
        bt.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void initData() {

        //每个图片的名字循环
        for (int j=0;j<s.length;j++){

            tv.setText(s[j]);

        }
        // viewpaper adapter适配器
        guids = new ArrayList<>();
        for (int i = 0; i < mPics.length; i++) {

            ImageView iv_temp = new ImageView(getApplicationContext());
            iv_temp.setBackgroundResource(mPics[i]);

            //添加界面的数据
            guids.add(iv_temp);

            //灰色的点在LinearLayout中绘制：
            //获取点
            View v_point = new View(getApplicationContext());
            //灰点背景色
            v_point.setBackgroundResource(R.drawable.point_smiple);
            //设置灰色点的显示大小
            int dip = 10;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip, dip);
            //设置点与点的距离,第一个点除外
           if (i != 0){
               params.leftMargin = 47;
               v_point.setLayoutParams(params);

               ll.addView(v_point);

           }

            initEvent();
        }

        // 创建viewpager的适配器
        guideAdapter = new GuideAdapter(getApplicationContext(), guids);
        // 设置适配器
        vp.setAdapter(guideAdapter);



    }
    private void initEvent() {
        //监听界面绘制完成
        vw.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {



            @Override
            public void onGlobalLayout() {
                //取消注册界面而产生的回调接口
                vw.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //计算点于点之间的距离
                disPoints = ll.getChildAt(1).getLeft() - ll.getChildAt(0).getLeft();
            }
        });
        //滑动事件监听滑动距离，点更随滑动。
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                //计算点的左边距
                float leftMargin = disPoints * (i + i1);
                //设置点的左边距
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) vw.getLayoutParams();
                //对folat类型进行四舍五入，
                layoutParams.leftMargin = Math.round(leftMargin);
                //设置位置
                vw.setLayoutParams(layoutParams);

            }

            @Override
            public void onPageSelected(int position) {

                //当前viewpager显示的页码
                //如果viewpager滑动到第三页码（最后一页），显示进入的button
                if (position == guids.size() - 1) {
                   bt.setVisibility(View.VISIBLE);//设置按钮的显示
                } else {
                    //隐藏该按钮
                    bt.setVisibility(View.GONE);
                }
                currentItem = position;
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(login_GuidepageActivity.this, login_LoginActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });
        //给页面设置触摸事件
        vp.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float endX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width = size.x;
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if (currentItem == (guids.size() - 1) && startX - endX >= (width / 4)) {
                            //进入主页
                            Intent intent = new Intent(login_GuidepageActivity.this, login_LoginActivity.class);
                            startActivity(intent);
                            //这部分代码是切换Activity时的动画，看起来就不会很生硬
                            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                            finish();
                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }



}




