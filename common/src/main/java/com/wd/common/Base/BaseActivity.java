package com.wd.common.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        StatusBarUtil.setTransparent(this);
        setContentView(getLayout());
        mPresenter = initPresenter();
        initView();
        initData();
    }

    protected P getPresenter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    /**
     * 加载布局文件
     * @return
     */
    protected abstract int getLayout();

    /**
     * MVP框架
     * @return
     */
    protected abstract P initPresenter();

    /**
     * 找控件
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void initData();
}
