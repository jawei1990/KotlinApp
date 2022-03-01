package com.example.interviewtest

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
   var itemList  = ArrayList<ItemModel>()
    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.grid)

        insertData()
        setGridAdapter()
        gridItemClick()
    }

    fun setGridAdapter()
    {
        var customAdapter = CustomAdapter(itemList,this)
        gridView.adapter = customAdapter
    }

    fun gridItemClick()
    {
        gridView.setOnItemClickListener { parent, view, postion, id ->
            var tvItemBack = view?.findViewById<ImageView>(R.id.image)
            var tvItemName = view?.findViewById<TextView>(R.id.text)

            val current = tvItemName?.getCurrentTextColor()

            if(current == Color.parseColor("#FFFFFF"))
            {
                if(itemList[postion].color == 0)
                {
                    tvItemName?.setTextColor(Color.parseColor("#66C000"))
                    tvItemBack?.setImageResource(R.drawable.rect_light_green)
                }
                else if(itemList[postion].color == 1)
                {
                    tvItemName?.setTextColor(Color.parseColor("#0080FF"))
                    tvItemBack?.setImageResource(R.drawable.rect_light_blue)
                }
                else
                {
                    tvItemName?.setTextColor(Color.parseColor("#FF3333"))
                    tvItemBack?.setImageResource(R.drawable.rect_light_red)
                }
            }
            else
            {
                tvItemName?.setTextColor(Color.parseColor("#FFFFFF"))

                if(itemList[postion].color == 0)
                    tvItemBack?.setImageResource(R.drawable.rect_green)
                else if(itemList[postion].color == 1)
                    tvItemBack?.setImageResource(R.drawable.rect_blue)
                else
                    tvItemBack?.setImageResource(R.drawable.rect_red)
            }
        }
    }

    fun insertData()
    {
        var x:Int = 0
        var y:Int = 0
        var pos:Int = 0
        var color:Int = 0
        for(i in 1 until 50)
        {
            x = i % 5
            y = i / 5

            if(x == 0)
            {
                x = 5
                y -= 1
            }

            pos = (x-1)*10 + y
            pos %= 12
            if(1 <= pos && pos <= 4)
                color = 0
            else if(5 <= pos && pos <= 8)
                color = 1
            else
                color = 2

            itemList.add(ItemModel(String.format("%02d",i),R.drawable.rect_default,color))
        }
    }


}