package com.example.recipelist.presenter

import android.content.Context
import com.example.recipelist.ui.MainView
import com.example.recipelist.model.RecipeInteractorImpl


class RecipePresenterImpl(private var view: MainView?, private val interactor:RecipeInteractorImpl?)
    :RecipePresenter {
    override fun loadList(json:String) {
        val recipeList = interactor?.getRecipesList(json)
        if (recipeList != null) {
            view?.showRecipe(recipeList)
        }
    }

    override fun destory() {
        view = null
    }

    override fun loadJsonFromAsset(filename: String){
        var json: String? = null

        try {
            val context: Context? = view?.getViewContext()
            if(context != null)
            {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
                loadList(json)
            }
        } catch (ex: java.io.IOException) {
            ex.printStackTrace()
        }
    }


}