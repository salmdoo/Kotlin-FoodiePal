package com.example.foodiepal.recipe

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodiepal.R
import com.example.foodiepal.databinding.FragmentRecipesBinding
import com.example.foodiepal.databinding.PopupAddRecipeBinding

class RecipesFragment : Fragment() {
    private lateinit var binding: FragmentRecipesBinding
    private lateinit var recipeResources: RecipeResources
    private lateinit var recipeAdapter: RecipeAdapter

    private fun getResource(){
        val names =  resources.getStringArray(R.array.recipe_name).toMutableList()
        val ingredients =  resources.getStringArray(R.array.recipe_ingredient).toMutableList()
        val instructions =  resources.getStringArray(R.array.recipe_instruction).toMutableList()
        val stars =  resources.getIntArray(R.array.recipe_star).toMutableList()
        val cookingTimes =  resources.getIntArray(R.array.time_cooking).toMutableList()
        val recipeImages = intArrayOf(
            R.drawable.spaghetti_bolognese,
            R.drawable.chicken_stir_fry,
            R.drawable.caprese_salad,
            R.drawable.vegetarian_quinoa_bowl,
        ).toMutableList()

        recipeResources = RecipeResources(names.size,
            names, recipeImages,stars, cookingTimes, ingredients, instructions)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getResource()
        binding = FragmentRecipesBinding.inflate(inflater, container, false)
        val recipeScrollview = binding.recipeRecycleView
        recipeScrollview.layoutManager = GridLayoutManager(requireContext(), 1)
        recipeAdapter = RecipeAdapter(requireContext(), recipeResources ).also { recipeScrollview.adapter = it }

        binding.addRecipePopupBtn.setOnClickListener {
            showAddRecipePopup(inflater, container)
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun showAddRecipePopup(inflater: LayoutInflater, container: ViewGroup?){
        val popupView = PopupAddRecipeBinding.inflate(inflater, container, false)
        val popupWindow = PopupWindow(popupView.root, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true)
        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        popupView.addRecipeBtn.setOnClickListener {
            val name = popupView.recipeName.text.toString()
            val ingredient = popupView.recipeIngredient.text.toString()
            val instruction = popupView.recipeInstruction.text.toString()
            recipeResources.add(name, R.drawable.meals_default, 5, 10, ingredient, instruction)
            recipeAdapter.notifyDataSetChanged()
            popupWindow.dismiss()
        }

        popupView.cancelBtn.setOnClickListener {
            popupWindow.dismiss()
        }

        popupWindow.showAtLocation(popupView.root, Gravity.CENTER, 0, 0)
    }


}