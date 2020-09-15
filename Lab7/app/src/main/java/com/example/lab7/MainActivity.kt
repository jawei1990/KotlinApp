package com.example.lab7

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_gridview.*

class MainActivity : AppCompatActivity() {

    data class Item
    (
        val idx_img:Int,
        val name: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listItem = arrayListOf("項目1","項目2","項目3",
            "項目4","項目5","項目6",
            "項目7","項目8","項目9")
        val item = ArrayList<Item>()
        val array = resources.obtainTypedArray(R.array.fruit_list)

        for(i in 0 until array.length())
            item.add(Item(array.getResourceId(i,0),"水果${i+1}"))

        array.recycle()
        sp_fruit.adapter = FruitAdapter(R.layout.layout_spinner,item)
        gv_fruit.adapter = FruitAdapter(R.layout.layout_gridview,item)
        lv_fruit.adapter = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, listItem)

        sp_fruit.onItemSelectedListener = object: AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"水果${position+1}",Toast.LENGTH_SHORT).show()
            }
        }

        gv_fruit.setOnItemClickListener {
                parent, view, position, id ->
                Toast.makeText(this@MainActivity,"----- 水果 --- ${position+1}",Toast.LENGTH_SHORT).show()
        }

        lv_fruit.setOnItemClickListener {
            parent, view, position, id ->
            Toast.makeText(this@MainActivity,"${listItem[position]}",Toast.LENGTH_SHORT).show()
        }
    }
}