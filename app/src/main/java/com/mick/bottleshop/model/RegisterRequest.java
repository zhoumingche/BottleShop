package com.mick.bottleshop.model;

import com.google.gson.annotations.SerializedName;

public class RegisterRequest {


    @SerializedName("androidId")
    public String androidId;
    @SerializedName("machineIp")
    public String machineIp;
}
