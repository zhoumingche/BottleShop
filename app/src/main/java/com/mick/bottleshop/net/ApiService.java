package com.mick.bottleshop.net;

import com.mick.bottleshop.model.BaseResult;
import com.mick.bottleshop.model.LoginRequest;
import com.mick.bottleshop.model.LoginResponse;
import com.mick.bottleshop.model.RegisterRequest;
import com.mick.bottleshop.model.RegisterResponse;
import com.mick.bottleshop.model.WineListRequest;
import com.mick.bottleshop.model.WineListResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("machine/register")
    Observable<BaseResult<RegisterResponse>> register(@Body RegisterRequest request);

    @POST("mLogin")
    Observable<BaseResult<LoginResponse>> login(@Body LoginRequest request);

    @POST("machine/query")
    Observable<BaseResult<WineListResponse>> getWineList(@Body WineListRequest request);

    //
//    //URL= www.sangyiwen.top/order/wine/get?orderId=123
//    @GET("order/wine/get")
//    Observable<BaseResult<OrderStatusResponse>> getOrderStatus(@Query("orderId") String orderId);
//
//    //URL= www.sangyiwen.top/order/wine/callback
//
//    @POST("order/wine/callback")
//    Observable<BaseResult<Boolean>> notifyTradeSus(@Body NotifySucRequest request);
//
//    @POST("command/receive")
//    Observable<BaseResult<Object>> PostReceiveData(@Body PostReceiveRequest request);

//    @POST("https://www.sangyiwen.top/order/wine/query")
//    Observable<BaseResult<Object>> PostReceiveData(@Body PostReceiveRequest request);
}