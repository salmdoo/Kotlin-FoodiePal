package com.example.foodiepal.mealPlan

data class MealPlanData(val weekday: String, val meals: MutableList<MealPlanItemData>)
data class  MealPlanItemData (val mealName: String, val mealList: MutableList<String>)
