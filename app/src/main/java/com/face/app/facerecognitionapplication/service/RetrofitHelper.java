package com.face.app.facerecognitionapplication.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit请求辅助类
 *
 * @author Leo
 * @time 2018/6/22 10:01
 */
public class RetrofitHelper {

    private Context mContext;
    // 缓存路径
    private static final String FilePath = "OKHTTPCacheFile";
    // 缓存大小
    private static final int cacheSize = 10 * 1024 * 1024; // 10 MiB
    // 链接缓存时间 单位秒
    private static final int conectTimeout = 10;
    // 写入缓存时间 单位秒
    private static final int writeTimeout = 10;
    // 读取缓存时间 单位秒
    private static final int readTimeout = 10;

    private OkHttpClient client = null;
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());

    /**
     * 这是一个单例模式
     */
    private static RetrofitHelper instance = null;
    private Retrofit mRetrofit = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    private RetrofitHelper(Context mContext) {
        this.mContext = mContext;
        init();
    }

    // 初始化mOkHttpClient
    private void initOkHttpUtil() {
        if (client == null) {
            synchronized (RetrofitHelper.class) {
                if (client == null) {
                    File cacheDirectory = new File(FilePath);
                    Cache cache = new Cache(cacheDirectory, cacheSize);
                    client = new OkHttpClient().newBuilder()
                            .cache(cache)
                            // 最好不要更改cache目录
                            .connectTimeout(conectTimeout, TimeUnit.SECONDS)
                            // 设置相应时间
                            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                            .readTimeout(readTimeout, TimeUnit.SECONDS).build();
                }
            }
        }
    }

    private void init() {
        initOkHttpUtil();
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://newswifiapi.dfshurufa.com/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 获取请求实例
     */
    public RetrofitService getServer() {
        return mRetrofit.create(RetrofitService.class);
    }
}
