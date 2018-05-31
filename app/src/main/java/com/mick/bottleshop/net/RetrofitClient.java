package com.mick.bottleshop.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final static String BASE_URL = "https://www.sangyiwen.top/";
    private static Retrofit mRetrofit;

    public static Retrofit get() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkhttpClient.get())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public static <T> T get(Class<T> tClass) {
        return get().create(tClass);
    }

    public static ApiService getApiService() {
        return get().create(ApiService.class);
    }


}
