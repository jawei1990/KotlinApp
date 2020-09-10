package com.example.lab3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.lab3.R.id.btnMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMenu.setOnClickListener()
        {
            val intent = Intent(this,MainActivity2::class.java)
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {
            if (resultCode == Activity.RESULT_OK) {
                tv_drink.text = "${it.get("drink").toString()}"
                tv_sweet.text = "${it.get("sweet").toString()}"
                tv_ice.text = "${it.get("ice").toString()}"
            }
            else
            {
                return
            }
        }

    }
}
