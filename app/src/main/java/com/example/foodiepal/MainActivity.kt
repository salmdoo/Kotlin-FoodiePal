package com.example.foodiepal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.foodiepal.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.appTabLayout.tabGravity = TabLayout.GRAVITY_FILL
        MainAdapter(supportFragmentManager, lifecycle).also { binding.appViewPager.adapter = it }
        TabLayoutMediator(binding.appTabLayout, binding.appViewPager) { tab, position ->
            when (position){
                0 -> {
                    tab.text = "Recipe"
                    tab.setIcon(R.drawable.recipe_icon)
                }
                1 -> {
                    tab.text = "Meal planner"
                    tab.setIcon(R.drawable.meal_plan_icon)
                }
                2 -> {
                    tab.text = "Blog"
                    tab.setIcon(R.drawable.blog_icon)
                }
                3 -> {
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.contact_icon)
                }
                4 -> {
                    tab.text = "About me"
                    tab.setIcon(R.drawable.about_me_icon)
                }
            }
        }.attach()

        binding.bottomNavigationMenu.setOnNavigationItemReselectedListener() {
            when(it.itemId) {
                R.id.recipeMenu -> binding.appViewPager.currentItem = 0
                R.id.mealPlanMenu -> binding.appViewPager.currentItem = 1
                R.id.blogMenu -> binding.appViewPager.currentItem = 2
                else -> binding.appViewPager.currentItem = 0
            }
        }


    }

}
