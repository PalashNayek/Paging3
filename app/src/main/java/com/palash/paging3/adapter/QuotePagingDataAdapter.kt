package com.palash.paging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.palash.paging3.databinding.QuoteItemBinding
import com.palash.paging3.models.Result

class QuotePagingDataAdapter : PagingDataAdapter<Result, QuotePagingDataAdapter.QuoteViewHolder>(DiffUtilsCallback()) {

    inner class QuoteViewHolder(private val binding: QuoteItemBinding) : ViewHolder(binding.root) {

        fun bind(item : Result){
            binding.quote.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item= getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }

    class DiffUtilsCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}