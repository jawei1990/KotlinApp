package com.example.recipelist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.recipelist.data.Recipe
import com.example.recipelist.model.RecipeInteractorImpl
import com.example.recipelist.presenter.RecipePresenter
import com.example.recipelist.presenter.RecipePresenterImpl
import com.example.recipelist.ui.MainView
import com.example.recipelist.ui.RecipeAdapter

class MainActivity : AppCompatActivity() , MainView {
    private lateinit var listView : ListView
    private lateinit var presenter : RecipePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.recipe_list_view)
        presenter = RecipePresenterImpl(this,RecipeInteractorImpl())
        presenter.loadJsonFromAsset("recipes.json")
    }

    fun listClick(list: ArrayList<Recipe>)
    {
        listView.isClickable = true
        listView.setOnItemClickListener { adapterView, view,  position, l ->
            var item = list[position]
            val intent = DetailActivity.newIntent(this,item)
            startActivity(intent)
        }
    }

    override fun showRecipe(list: ArrayList<Recipe>) {
        val adapter = RecipeAdapter(list)
        listView.adapter = adapter
        listClick(list)
    }

    override fun getViewContext(): Context {
        return baseContext;
    }
}