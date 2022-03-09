package com.example.recipelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.recipelist.data.Recipe
import com.example.recipelist.model.RecipeInteractorImpl
import com.example.recipelist.presenter.RecipePresenterImpl

class DetailActivity :AppCompatActivity() {
    private lateinit var webView: WebView

    companion object
    {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"
        fun newIntent(context: Context,item:Recipe) :Intent
        {
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(EXTRA_TITLE,item.title)
            intent.putExtra(EXTRA_URL,item.instructionUrl)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.extras?.getString(EXTRA_TITLE)
        val url = intent.extras?.getString(EXTRA_URL)

        setTitle(title)
        webView = findViewById(R.id.detail_web_view)
        webView.webViewClient = WebViewClient()

        if(url != null)
            webView.loadUrl(url)
    }

}