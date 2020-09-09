package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BtnStart.setOnClickListener{
            Log.e("Awei","Press")
            if(ed_name.length() < 1)
                tv_text.setText("請輸入玩家姓名")
            else
            {
                tv_name.text = "${ed_name.text}"
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
                    }

                    btn_scissor.isChecked && comp == 0 ||
                            btn_stone.isChecked && comp == 1||
                            btn_paper.isChecked && comp == 2 ->
                    {
                        tv_winner.text = "平手"
                    }

                    else ->
                    {
                        tv_winner.text = "你贏了"
                    }

                }
            }

        }
    }
}

