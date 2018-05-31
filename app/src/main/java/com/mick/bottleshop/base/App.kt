package com.mick.bottleshop.base

import android.app.Application
import com.blankj.utilcode.util.Utils
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        mApp = this
        Utils.init(this)

        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  //（可选）是否显示线程信息。 默认值为true
                .methodCount(2)         // （可选）要显示的方法行数。 默认2
                .methodOffset(7)        // （可选）隐藏内部方法调用到偏移量。 默认5
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))


    }

    companion object {
        lateinit var mApp: App
        @JvmStatic
        fun getInstance(): App {
            return mApp
        }
    }


}