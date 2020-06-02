package com.wd.common.utiuls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;


import com.wd.common.Base.BaseApplication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetUtils {
    String BaseUrl="http://mobile.bwstudent.com/health/";
    private NetUtils(){
        initHttp();
    }

    private static class AAA{
        private static final NetUtils RET_UTILS = new NetUtils();
    }

    public static NetUtils getInstance(){
        return AAA.RET_UTILS;
    }

    public boolean isNetWork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return true;
        }
        return false;
    }

    private Retrofit initHttp() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient build = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HandlerInt())
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(build)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public class HandlerInt implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            String userid = SPUtils.getString(BaseApplication.getAppContext(),SPUtils.NAME,SPUtils.USERID);
            String sessionid = SPUtils.getString(BaseApplication.getAppContext(),SPUtils.NAME,SPUtils.SESSIONID);

            if (TextUtils.isEmpty(userid) || TextUtils.isEmpty(sessionid)){
                return chain.proceed(request);
            }

            Request build = request.newBuilder()
                    .addHeader("userId", userid)
                    .addHeader("sessionId", sessionid)
                    .build();

            return chain.proceed(build);
        }
    }
    public <T>T getRetrofitServie(Class<T> cls){
        return initHttp().create(cls);
    }

}
