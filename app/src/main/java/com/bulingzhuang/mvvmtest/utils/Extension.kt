package com.bulingzhuang.mvvmtest.utils

import android.content.Context
import android.widget.Toast

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/16
 * 描    述：
 * ================================================
 */
/**
 * 普通Toast
 */
fun Context.showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}