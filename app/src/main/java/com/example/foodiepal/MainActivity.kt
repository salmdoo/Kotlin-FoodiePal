package com.example.foodiepal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.foodiepal.aboutMe.AboutMeFragment
import com.example.foodiepal.blog.BlogFragment
import com.example.foodiepal.contact.ContactFragment
import com.example.foodiepal.databinding.ActivityMainBinding
import com.example.foodiepal.mealPlan.MealPlanFragment
import com.example.foodiepal.recipe.RecipesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentManager: FragmentManager
    private lateinit var  fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.recipeBtn.setOnClickListener { clickRecipe() }
        binding.foodPlanBtn.setOnClickListener { clickMealPlan() }
        binding.blogBtn.setOnClickListener { clickBlog() }
        binding.contactBtn.setOnClickListener { clickContact() }
        binding.aboutMeBtn.setOnClickListener { clickAboutMe() }
        setContentView(binding.root)

        fragmentManager = supportFragmentManager //Get the fragment transaction of the current activity
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, RecipesFragment())
        fragmentTransaction.commit()

    }
    fun clickRecipe(){
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, RecipesFragment())
        fragmentTransaction.commit()
    }

    fun clickMealPlan(){
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, MealPlanFragment())
        fragmentTransaction.commit()
    }

    fun clickBlog(){
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, BlogFragment())
        fragmentTransaction.commit()
    }

    fun clickContact(){
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, ContactFragment())
        fragmentTransaction.commit()
    }

    fun clickAboutMe(){
        fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, AboutMeFragment())
        fragmentTransaction.commit()
    }
}
