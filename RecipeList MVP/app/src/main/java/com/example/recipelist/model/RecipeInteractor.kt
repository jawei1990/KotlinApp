package com.example.recipelist.model

import com.example.recipelist.data.Recipe

interface RecipeInteractor {
    fun getRecipesList(jsonString : String): ArrayList<Recipe>
}