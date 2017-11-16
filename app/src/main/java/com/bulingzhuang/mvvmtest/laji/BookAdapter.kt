package com.bulingzhuang.mvvmtest.laji

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bulingzhuang.mvvmtest.databinding.AdapterBookBinding

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/16
 * 描    述：
 * ================================================
 */
class BookAdapter(private val mDataList: ArrayList<Book>, private val listener: OnItemClickListener) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(collection: Collection<Book>) {
        mDataList.clear()
        mDataList.addAll(collection)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = AdapterBookBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(mDataList[position], listener)
    }

    override fun getItemCount(): Int = mDataList.size

    class ViewHolder(private var binding: AdapterBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Book, listener: OnItemClickListener?) {
            binding.book = item
            if (listener != null) {
                binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            }
            binding.executePendingBindings()
        }
    }
}