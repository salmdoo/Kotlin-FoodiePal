package com.example.foodiepal.recipe

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodiepal.R
import com.example.foodiepal.databinding.RecipeItemBinding

class RecipeAdapter(val context: Context, val resources: RecipeResources) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    inner class RecipeViewHolder(val binding: RecipeItemBinding): ViewHolder(binding.root){
        fun bind(recipe: RecipeData, recipeDetails: RecipeDetails) {
            binding.recipeName.text = recipe.name
            binding.recipeImage.setImageResource(recipe.image)
            binding.recipeStar.text = "${recipe.stars} stars"
            binding.recipeTimeCooking.text = "${recipe.cookingTime} mins"

            binding.recipeItemClickable.setOnClickListener{
                val detailsFragment = RecipeDetailsFragment.newInstance(recipeDetails)
                (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, detailsFragment)
                    .commit()
            }
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

        val recipe = RecipeData(name, image, star, timeCooking)
        val  recipeDetails = RecipeDetails(
            name,
            image,
            star,
            timeCooking,
            resources.ingredients[position],
            resources.instructions[position])

        holder.bind(recipe, recipeDetails)
    }
}