package com.mick.bottleshop.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

public class BaseResult<T> {


    @SerializedName("code")
    public String code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("value")
    public T value;

    public boolean isSuccess() {
        return TextUtils.equals(code, "200");
    }


}
