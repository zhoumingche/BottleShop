package com.mick.bottleshop.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    protected var mCompositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    protected fun getCompositeDisposable(): CompositeDisposable {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }

        return mCompositeDisposable as CompositeDisposable
    }


    override fun onDestroy() {
        super.onDestroy()
        if (mCompositeDisposable != null && !mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable!!.isDisposed
            mCompositeDisposable = null
        }
    }
}