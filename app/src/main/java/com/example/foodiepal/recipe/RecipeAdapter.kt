package com.example.foodiepal.recipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.R
import com.example.foodiepal.databinding.RecipeItemBinding
import java.lang.Float.parseFloat

class RecipeAdapter(val context: Context, val resources: RecipeResources) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    inner class RecipeViewHolder(val binding: RecipeItemBinding): ViewHolder(binding.root){
        fun bind(recipe: RecipeDetails) {
            binding.recipeName.text = recipe.name
            binding.recipeImage.setImageResource(recipe.image)
            var ratingRecipe = binding.recipeStar
            ratingRecipe.rating = parseFloat(recipe.star.toString())
            binding.recipeTimeCooking.text = "${recipe.cookingTime} mins"
            binding.recipeInstruction.text = recipe.instruction
            binding.recipeIngredient.text = recipe.ingredient
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
     val binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int = resources.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
       val name = resources.names[position]
        val image = resources.images[position]
        val star = resources.stars[position]
        val timeCooking = resources.cookingTimes[position]

        val  recipe = RecipeDetails(
            name,
            image,
            star,
            timeCooking,
            resources.ingredients[position],
            resources.instructions[position])

        holder.bind(recipe)
    }
}