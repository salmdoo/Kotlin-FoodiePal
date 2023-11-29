package com.example.foodiepal.mealPlan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal.databinding.FragmentMealBinding

class MealPlanFragment : Fragment() {
    val mealPlans : MutableList<MealPlanData> = mutableListOf()

    fun initData(){
        mealPlans.add(MealPlanData("Monday",
            mutableListOf(
                MealPlanItemData("Breakfast", mutableListOf("Avocado Toast with Poached Eggs")),
                MealPlanItemData("Lunch", mutableListOf("Quinoa Salad", "Grilled chicken or chickpeas for protein")),
                MealPlanItemData("Dinner", mutableListOf("Baked Salmon with Roasted Vegetables")))
            ))
        mealPlans.add(MealPlanData("Tuesday",
            mutableListOf(
                MealPlanItemData("Breakfast", mutableListOf("Greek Yogurt Parfait")),
                MealPlanItemData("Lunch", mutableListOf("Turkey and Avocado Wrap", "Avocado, lettuce, tomato", "Whole-grain wrap filled with sliced turkey")),
                MealPlanItemData("Dinner", mutableListOf("Baked Salmon with Roasted Vegetables", "Vegetable Stir-Fry with Tofu")))
            ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initData()

        val binding = FragmentMealBinding.inflate(inflater, container, false)
        val recyclerView = binding.mealPlanRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        MealPlanAdapter(requireContext(), mealPlans).also { recyclerView.adapter = it }

        // Inflate the layout for this fragment
        return binding.root
    }

}