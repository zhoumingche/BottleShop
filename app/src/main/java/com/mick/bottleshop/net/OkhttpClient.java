package com.mick.bottleshop.net;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.mick.bottleshop.global.SPKey;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpClient {
    private static final String COOKIE = "Cookie";
    private static final String JSESSIONID = "JSESSIONID";
    private static OkHttpClient mOkHttpClient;
    private final static HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR =
            new HttpLoggingInterceptor(message -> Logger.d(message))
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * 因为设置了读写超时，该client不适用于上传和下载
     */
    public static OkHttpClient get() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    //log 拦截器
                    .addInterceptor(HTTP_LOGGING_INTERCEPTOR)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(mTokenInterceptor)
                    .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                    .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                    .build();
        }
        return mOkHttpClient;
    }

    static Interceptor mTokenInterceptor = chain -> {
        Request originalRequest = chain.request();
        if (TextUtils.isEmpty(SPUtils.getInstance().getString(SPKey.SESSION_ID))) {
            return chain.proceed(originalRequest);
        }
        Request authorised = originalRequest.newBuilder()
//                .header(Constants.JSESSIONID, SPUtils.getInstance().getString(SPKey.SESSION_ID))
                .header(COOKIE, JSESSIONID + "=" + SPUtils.getInstance().getString(SPKey.SESSION_ID))
                .build();
        return chain.proceed(authorised);
    };


}
