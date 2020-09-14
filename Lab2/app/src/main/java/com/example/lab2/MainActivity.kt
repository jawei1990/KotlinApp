package com.example.lab2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast_test.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnStart.setOnClickListener{
            Log.e("Awei","Press")
            if(ed_name.length() < 1)
                showAlert(this)
            else
            {
                val name = "${ed_name.text}"
                tv_name.text = name
                tv_our.text = "${ if(btn_scissor.isChecked)"剪刀"
                else if(btn_stone.isChecked)"石頭"
                else "布"}"

                val comp = (Math.random()* 3).toInt()
                tv_comp.text = "${if(comp == 0) "剪刀"
                else if(comp == 1)"石頭"
                else "布"}"

                when
                {
                    btn_scissor.isChecked && comp == 1 ||
                            btn_stone.isChecked && comp == 2||
                            btn_paper.isChecked && comp == 0 ->
                    {
                        tv_winner.text = "你輸了"
                        toastMsg(this,name,"你輸了")
                    }

                    btn_scissor.isChecked && comp == 0 ||
                            btn_stone.isChecked && comp == 1||
                            btn_paper.isChecked && comp == 2 ->
                    {
                        tv_winner.text = "平手"
                        toastMsg(this,name,"平手")
                    }

                    else ->
                    {
                        tv_winner.text = "你贏了"
                        toastMsg(this,name,"你贏了")
                    }
                }
            }
        }
    }

    fun showAlert(mContex:Context)
    {
        AlertDialog.Builder(mContex)
            .setTitle("姓名未輸入")
            .setMessage("姓名未輸入,請輸入姓名")
            .setPositiveButton("OK",null)
            .show()
    }

    fun toastMsg(mContex:Context,name:String,msg:String)
    {
        val toast = Toast(mContex)
        toast.setGravity(Gravity.CENTER,0,50) // Toast 在畫面正中間
        val inflater2 = layoutInflater
        val view = inflater2.inflate(R.layout.toast_test,toast_View)
        toast.view = view
        val text = view.findViewById<TextView>(R.id.textMsg)
        text.text = name + msg
        toast.show()
    }
}

