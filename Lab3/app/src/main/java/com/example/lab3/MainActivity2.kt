package com.example.lab3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        BtnOK.setOnClickListener()
        {
            val bundle = Bundle()
            val StrSweet = "${ if (btn_no_sugar.isChecked) "無糖"
                               else if(btn_sugar30.isChecked)"微糖"
                               else if(btn_sugar50.isChecked)"半糖"
                               else if(btn_sugar70.isChecked)"少糖"
                               else "全糖"}"

            val StrIce = "${ if (btn_no_ice.isChecked) "完全去冰"
            else if(btn_ice30.isChecked)"微冰"
            else if(btn_ice50.isChecked)"半冰"
            else if(btn_ice70.isChecked)"少冰"
            else "全冰"}"
            bundle.putString("drink",ed_drink.text.toString())
            bundle.putString("sweet",StrSweet)
            bundle.putString("ice",StrIce)
            setResult(Activity.RESULT_OK,intent.putExtras(bundle))
            finish()
        }
    }
}