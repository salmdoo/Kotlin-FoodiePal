package com.example.foodiepal.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodiepal.aboutMe.AboutMeFragment
import com.example.foodiepal.blog.BlogFragment
import com.example.foodiepal.contact.ContactFragment
import com.example.foodiepal.mealPlan.MealPlanFragment
import com.example.foodiepal.recipe.RecipesFragment

class MainAdapter(fm: FragmentManager, lc: Lifecycle): FragmentStateAdapter(fm, lc) {
    override fun getItemCount() = 5
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RecipesFragment()
            1 -> MealPlanFragment()
            2 -> BlogFragment()
            3 -> ContactFragment()
            4 -> AboutMeFragment()
            else -> Fragment()
        }
    }
}