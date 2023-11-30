package com.example.foodiepal.aboutMe

import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.databinding.MealPlanSubitemBinding

class AboutMeAdapter(val aboutMe: MutableList<AboutMeData>): Adapter<AboutMeAdapter.AboutMeViewHolder>() {
    inner class AboutMeViewHolder(private var binding: MealPlanSubitemBinding) : ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutMeViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AboutMeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}