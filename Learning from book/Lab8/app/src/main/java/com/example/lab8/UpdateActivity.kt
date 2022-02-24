package com.example.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_content.*

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_content)

        BtnOK.setOnClickListener()
        {
            val nameLen = ed_name.length()
            val telLen = ed_tel.length()
            if(nameLen < 1)
                Toast.makeText(this,"請輸入名字",Toast.LENGTH_SHORT).show()
            else if(telLen < 1)
                Toast.makeText(this,"請輸入電話",Toast.LENGTH_SHORT).show()
            else
            {
                val bundle = Bundle()
                bundle.putString("name",ed_name.text.toString())
                bundle.putString("phone",ed_tel.text.toString())
                setResult(Activity.RESULT_OK,Intent().putExtras(bundle))
                finish()
            }
        }

        BtnCancel.setOnClickListener()
        {
            finish()
        }
    }
}