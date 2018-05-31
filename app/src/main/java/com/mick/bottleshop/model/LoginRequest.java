package com.mick.bottleshop.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {


    /**
     * account : 36b7c2c1-1298-493c-a1c3-c518b4f8fd6c
     * password : 815373729696329728
     */

    @SerializedName("account")
    public String account;
    @SerializedName("password")
    public String password;
}
