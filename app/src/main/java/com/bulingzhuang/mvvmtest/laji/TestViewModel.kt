package com.bulingzhuang.mvvmtest.laji

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/15
 * 描    述：ViewModel
 * ================================================
 */
open class TestViewModel : ViewModel() {
    private val repoModel = RepoModel()
    val text = ObservableField("老数据，等更新")
    val isLoading = ObservableField(false)
    val mBookList = MutableLiveData<ArrayList<Book>>()

    private val callback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            isLoading.set(false)
            text.set(data)
        }
    }

    open fun refresh() {
        isLoading.set(true)
        repoModel.refreshData(callback)
    }

    open fun refreshBook() {
        isLoading.set(true)
        repoModel.refreshBookData(object : OnBookReadyCallback {
            override fun onDataReady(data: ArrayList<Book>) {
                isLoading.set(false)
                mBookList.value = data
            }
        })
    }
}