package com.bulingzhuang.mvvmtest.laji

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.bulingzhuang.mvvmtest.R
import com.bulingzhuang.mvvmtest.databinding.ActivityTest2Binding

class Test2Activity : AppCompatActivity(), BookAdapter.OnItemClickListener {

    lateinit var mBinding: ActivityTest2Binding
    private val bookAdapter = BookAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test2)
        val viewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        mBinding.viewModel = viewModel
        mBinding.executePendingBindings()

        mBinding.rvContent.layoutManager = LinearLayoutManager(this)
        mBinding.rvContent.adapter = bookAdapter
        viewModel.mBookList.observe(this, Observer<ArrayList<Book>> { it?.let { bookAdapter.replaceData(it) } })
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "第$position 条，书名：${mBinding.viewModel?.mBookList?.value?.get(position)?.title}", Toast.LENGTH_SHORT).show()
    }
}
