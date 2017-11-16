package com.bulingzhuang.mvvmtest.model

import com.bulingzhuang.mvvmtest.net.BaseObserver
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/16
 * 描    述：
 * ================================================
 */
open class BaseModel {
    private val mCompositeDisposable = CompositeDisposable()

    fun doOnDestory() {
        if (mCompositeDisposable.isDisposed) {
            mCompositeDisposable.dispose()
        }
    }

    fun <BLZ> addSubscription(observable: Observable<BLZ>, observer: BaseObserver<BLZ>) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
        mCompositeDisposable.add(observer.disposable)
    }
}