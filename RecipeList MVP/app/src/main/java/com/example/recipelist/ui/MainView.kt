package com.example.recipelist.ui

import android.content.Context
import com.example.recipelist.data.Recipe

interface MainView {
    fun showRecipe(list:ArrayList<Recipe>)
    fun getViewContext():Context
}