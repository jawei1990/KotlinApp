package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnDefaultToast.setOnClickListener()
        {
            Toast.makeText(this,"預設Toast",Toast.LENGTH_SHORT).show()
        }


        BtnCostmerToast.setOnClickListener()
        {
            val toast = Toast(this)
            val toastView = layoutInflater.inflate(R.layout.toast_costmer,null)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.view = toastView
            toast.duration = Toast.LENGTH_SHORT
            toast.show()
        }

        BtnAlertDialog.setOnClickListener()
        {
            AlertDialog.Builder(this)
                .setTitle("按鍵式 AlertDialog")
                .setMessage("對話內容~")
                .setPositiveButton("OK"){
                    dialog, which ->   Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel",null)
                .setNeutralButton("知道了"){
                        dialog, which ->   Toast.makeText(this,"知道了",Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        BtnListAlertDialog.setOnClickListener()
        {
            val listItem = arrayOf("對話框1","對話框2","對話框3","對話框4","對話框5")
            AlertDialog.Builder(this)
                .setTitle("列表式對話框")
                .setItems(listItem)
                {
                    dialog,i->
                    Toast.makeText(this,listItem.get(i),Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        BtnRadioAlertDialog.setOnClickListener()
        {
            val listItem = arrayOf("對話框1","對話框2","對話框3","對話框4","對話框5")
            AlertDialog.Builder(this)
                .setTitle("單選式AlertDialog")
                .setSingleChoiceItems(listItem,0)
                {
                    dialog,i->
                    Toast.makeText(this,listItem.get(i),Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("OK",null)
                .show()
        }


    }
}