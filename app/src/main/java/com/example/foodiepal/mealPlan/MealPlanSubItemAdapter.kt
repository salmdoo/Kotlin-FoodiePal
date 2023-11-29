package com.example.foodiepal.mealPlan

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.databinding.MealPlanSubitemBinding

class MealPlanSubItemAdapter(val planItemList: MutableList<MealPlanItemData>): RecyclerView.Adapter<MealPlanSubItemAdapter.MealPlanItemViewHolder>() {

    inner class MealPlanItemViewHolder(private val binding: MealPlanSubitemBinding): ViewHolder(binding.root){
        fun bind(meal: MealPlanItemData){
            binding.mealName.text = meal.mealName
            val subItems = meal.mealList.joinToString("\n")
            binding.mealList.text = subItems
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanItemViewHolder {
        val binding = MealPlanSubitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealPlanItemViewHolder(binding)
    }

    override fun getItemCount(): Int = planItemList.size

    override fun onBindViewHolder(holder: MealPlanItemViewHolder, position: Int) {
        val meal = planItemList[position]
        holder.bind(meal)
    }
}