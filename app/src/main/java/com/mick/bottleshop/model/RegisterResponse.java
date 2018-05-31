package com.mick.bottleshop.model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    /**
     * machineCode : 36b7c2c1-1298-493c-a1c3-c518b4f8fd6c
     * password : 815373729696329728
     * alias : 815373722721202176
     */

    @SerializedName("machineCode")
    public String machineCode;
    @SerializedName("password")
    public String password;
    @SerializedName("alias")
    public String alias;
}
