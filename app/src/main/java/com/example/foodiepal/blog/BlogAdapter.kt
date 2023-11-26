package com.example.foodiepal.blog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.databinding.BlogItemBinding

class BlogAdapter(val blogs: MutableList<String>): RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {
    inner class BlogViewHolder(val binding: BlogItemBinding): ViewHolder(binding.root){
        fun bind(blog: String) {
            binding.blogName.text = blog
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = BlogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BlogViewHolder(binding)
    }

    override fun getItemCount(): Int = blogs.size

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val blog = blogs[position]
        holder.bind(blog)
    }
}