package com.mick.bottleshop.util

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import com.mick.bottleshop.base.App
import java.util.*

class Utils {


    companion object {
        @SuppressLint("MissingPermission")
        fun getAndroidId(): String {
            val tm = App.getInstance().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            val tmDevice: String
            val tmSerial: String
            val androidId: String = "test wine2" + android.provider.Settings.Secure.getString(App.getInstance().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID)
            tmDevice = "" + tm.deviceId
            tmSerial = "" + tm.simSerialNumber

            val deviceUuid = UUID(androidId.hashCode().toLong(), tmDevice.hashCode().toLong() shl 32 or tmSerial.hashCode().toLong())
            return deviceUuid.toString()
        }
    }


}