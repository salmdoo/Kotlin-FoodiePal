package com.example.foodiepal.blog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal.databinding.FragmentBlogBinding
import com.example.foodiepal.databinding.PopupAddBlogBinding

class BlogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var blogResource: MutableList<String> = mutableListOf()
    private lateinit var adapter: BlogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        blogResource.add("https://pinchofyum.com/sheet-pan-jambalaya")
        blogResource.add("https://pinchofyum.com/recipes/healthy-choices")
        val binding = FragmentBlogBinding.inflate(inflater, container, false)

        val recyclerView = binding.blogRecycleView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = BlogAdapter(blogResource).also {  recyclerView.adapter = it }

        binding.addBlogFloatBtn.setOnClickListener {
            clickAddBlogFloatBtn(inflater, container)
        }

        return binding.root
    }

    fun clickAddBlogFloatBtn( inflater: LayoutInflater, container: ViewGroup?){

        val popupView = PopupAddBlogBinding.inflate(inflater, container, false)
        val popupWindow = PopupWindow(popupView.root, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true)
        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        popupView.addBlogBtn.setOnClickListener {
            val blog = popupView.blogName.text.toString()
            blogResource.add(blog)
            adapter.notifyDataSetChanged()
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView.root, Gravity.CENTER, 0, 0)
    }
}