package com.example.foodiepal.mealPlan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.databinding.MealPlanItemBinding

class MealPlanAdapter(val context: Context, val mealPlans: MutableList<MealPlanData>): RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder>() {

    inner class MealPlanViewHolder(private val binding: MealPlanItemBinding): ViewHolder(binding.root) {
        fun bind(mealPlan: MealPlanData) {
            binding.weekday.text = mealPlan.weekday
            val planItemRecyclerView = binding.mealPlanItemRecyclerView
            planItemRecyclerView.layoutManager = LinearLayoutManager(context)
            MealPlanSubItemAdapter(mealPlan.meals).also { planItemRecyclerView.adapter = it }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanViewHolder {
        val binding = MealPlanItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MealPlanViewHolder(binding)
    }

    override fun getItemCount(): Int = mealPlans.size

    override fun onBindViewHolder(holder: MealPlanViewHolder, position: Int) {
        val plan = mealPlans[position]
        holder.bind(plan)
    }
}