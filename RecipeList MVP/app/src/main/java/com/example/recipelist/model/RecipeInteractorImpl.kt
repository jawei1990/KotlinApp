package com.example.recipelist.model

import com.example.recipelist.data.Recipe
import org.json.JSONException
import org.json.JSONObject

class RecipeInteractorImpl :RecipeInteractor {
    override fun getRecipesList(jsonString: String): ArrayList<Recipe> {
        val recipeList = ArrayList<Recipe>()

        try {
            // Load data
            // val jsonString = Recipe.loadJsonFromAsset("recipes.json", context)
            val json = JSONObject(jsonString)
            val recipes = json.getJSONArray("recipes")

            // Get Recipe objects from data
            (0 until recipes.length()).mapTo(recipeList) {
                Recipe(recipes.getJSONObject(it).getString("title"),
                    recipes.getJSONObject(it).getString("description"),
                    recipes.getJSONObject(it).getString("image"),
                    recipes.getJSONObject(it).getString("url"),
                    recipes.getJSONObject(it).getString("dietLabel"))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return recipeList
    }
}