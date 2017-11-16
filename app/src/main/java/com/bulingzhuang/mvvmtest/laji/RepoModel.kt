package com.bulingzhuang.mvvmtest.laji

import android.os.Handler

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/15
 * 描    述：Model
 * ================================================
 */
class RepoModel {
    fun refreshData(callback: OnDataReadyCallback) {
        Handler().postDelayed({ callback.onDataReady("新数据") }, 2000)
    }

    fun refreshBookData(callback: OnBookReadyCallback) {
        Handler().postDelayed({
            callback.onDataReady(arrayListOf(
                    Book("伊拉龙", "忘记了", "遗产三部曲第一部", "小学"),
                    Book("三个代表重要思想", "黑框眼镜", "emmm.....没看过", "很早"),
                    Book("第一行代码", "郭霖", "《第一行代码——Android》是Android初学者的最佳入门书。全书由浅入深、系统全面地讲解了Android软件开发的方方面面。", "2014-08")
            ))
        }, 2000)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(data: String)
}

interface OnBookReadyCallback {
    fun onDataReady(data: ArrayList<Book>)
}