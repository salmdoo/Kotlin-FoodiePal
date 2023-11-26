package com.example.foodiepal.recipe

import java.io.Serializable

data class RecipeData(val name: String, val image: Int, val stars: Int, val cookingTime: Int)

data class RecipeDetails(val name: String, val image: Int, val star: Int,
                         val cookingTime: Int, val ingredient: String, val instruction: String): Serializable

data class RecipeResources(
    var size: Int,
    val names: MutableList<String>,
    val images: MutableList<Int>,
    val stars: MutableList<Int>,
    val cookingTimes: MutableList<Int>,
    val ingredients: MutableList<String>,
    val instructions: MutableList<String>) {
    fun add(name: String, image: Int, star: Int, cookingTime: Int, ingredient: String, instruction: String) {
        names.add(name)
        images.add(image)
        stars.add(star)
        cookingTimes.add(cookingTime)
        ingredients.add(ingredient)
        instructions.add(instruction)
        size += 1
    }
}