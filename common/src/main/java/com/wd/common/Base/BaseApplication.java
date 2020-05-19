package com.wd.common.Base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;


public class BaseApplication extends Application {
    private static Context applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("dj", "in app");
        applicationContext = getApplicationContext();

        Fresco.initialize(this);
//        ARouter.openLog();     // 打印日志
//        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openLog();
            // 调试模式开启，如果在install run模式下运行，则必须开启调试模式
            ARouter.openDebug();
        ARouter.init(this);
        
    }
    public static Context getAppContext(){
        return applicationContext;
    }
}
