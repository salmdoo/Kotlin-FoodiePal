package com.example.foodiepal.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodiepal.databinding.FragmentRecipeDetailsBinding

class RecipeDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var recipeDetails: RecipeDetails? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            recipeDetails = it.getSerializable(ARG_RECIPE_DETAILS) as RecipeDetails?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        recipeDetails?.let {
            binding.imageView.setImageResource(it.image)
            binding.recipeName.text = it.name
            binding.recipeIngredient.text = it.ingredient
            binding.recipeInstruction.text = it.instruction
        }
        return  binding.root
    }

    companion object {
        private const val ARG_RECIPE_DETAILS = "recipeDetails"

        @JvmStatic
        fun newInstance(recipeDetails: RecipeDetails) =
            RecipeDetailsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_RECIPE_DETAILS, recipeDetails)
                }
            }
    }
}