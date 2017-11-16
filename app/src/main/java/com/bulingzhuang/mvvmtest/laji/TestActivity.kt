package com.bulingzhuang.mvvmtest.laji

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bulingzhuang.mvvmtest.R
import com.bulingzhuang.mvvmtest.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        mBinding.viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        mBinding.executePendingBindings()
    }
}
