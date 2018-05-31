package com.mick.bottleshop.ui.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.text.TextUtils
import com.blankj.utilcode.util.SPUtils
import com.mick.bottleshop.R
import com.mick.bottleshop.base.BaseActivity
import com.mick.bottleshop.databinding.ActivityMainBinding
import com.mick.bottleshop.global.SPKey
import com.mick.bottleshop.model.LoginRequest
import com.mick.bottleshop.model.RegisterRequest
import com.mick.bottleshop.net.ApiService
import com.mick.bottleshop.net.RetrofitClient
import com.mick.bottleshop.util.IPUtil
import com.mick.bottleshop.util.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        login()


    }

    private fun login() {

        if (!TextUtils.isEmpty(SPUtils.getInstance().getString(SPKey.ACCOUNT))) {
            register()
        } else {
            val account = "35874b1e7a1d4d2189455ff471d1c41"
            val password = "816206425452457984"
            val loginRequest = LoginRequest()
            loginRequest.account = account
            loginRequest.password = password
            login(loginRequest)
        }
    }


    private fun register() {
        val request = RegisterRequest()
        request.androidId = Utils.getAndroidId()
        request.machineIp = IPUtil.getIP(this)
        val service = RetrofitClient.get(ApiService::class.java)
        val observable = service.register(request)
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError({ throwable ->

                })
                .subscribe({ result ->
                    if (result.isSuccess) {
//                        loginRequest.account = result.value.machineCode
//                        loginRequest.password = result.value.password
//                        SPUtils.getInstance().put(SPKey.ACCOUNT, result.value.machineCode)
//                        SPUtils.getInstance().put(SPKey.PASSWORD, result.value.password)
//                        SPUtils.getInstance().put(SPKey.ALIAS, result.value.alias)
////                        JPushInterface.setAlias(this, 0, result.value.alias)
//                        login(loginRequest)
                    } else {
                    }
                })
    }

    private fun login(loginRequest: LoginRequest) {
        RetrofitClient.getApiService().login(loginRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError({ throwable ->

                })
                .subscribe({ result ->
                    if (result.isSuccess) {
                        SPUtils.getInstance().put(SPKey.SESSION_ID, result.value.sessionId)
                    } else {
                    }
                })
    }

}
