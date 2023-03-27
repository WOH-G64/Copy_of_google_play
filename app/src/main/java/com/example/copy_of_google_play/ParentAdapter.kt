package com.example.copy_of_google_play

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.copy_of_google_play.databinding.ParentItemBinding

class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ParentViewHolder>() {

    private val childAdapter = ChildAdapter()

    var parentList = mutableListOf<ParentItem>()
        set(value) {
            field = value
        }

    inner class ParentViewHolder(private val binding: ParentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(parentItem: ParentItem){
            binding.apply {
                childRv.adapter = childAdapter
                parentItemTitle.text = parentItem.title
                childAdapter.childList = parentItem.childItem.toMutableList()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(ParentItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)))
    }

    override fun getItemCount() = parentList.size

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        holder.bind(parentList[position])
    }
}