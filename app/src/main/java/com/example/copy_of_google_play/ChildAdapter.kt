package com.example.copy_of_google_play

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.copy_of_google_play.databinding.ChildItemBinding

class ChildAdapter: RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    var childList = mutableListOf<ChildItem>()
        set(value) {
            field = value
        }

    inner class ChildViewHolder(private val binding: ChildItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(childItem: ChildItem){
            binding.childItemTitle.text = childItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        return ChildViewHolder(ChildItemBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)))
    }

    override fun getItemCount() = childList.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bind(childList[position])
    }
}