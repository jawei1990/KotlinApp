package com.example.recipelist.presenter

interface RecipePresenter {
    fun loadJsonFromAsset(json:String)
    fun loadList(json:String)
    fun destory()
}