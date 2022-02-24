package com.example.lab13

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(){

    private lateinit var dbrw: SQLiteDatabase
    private var item : ArrayList<String > = ArrayList()
    private lateinit var adapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbrw = MyDbHelper(this).writableDatabase
        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,item)
        listView.adapter = adapter

        BtnSearch.setOnClickListener()
        {
            val c = dbrw.rawQuery(if(et_bookName.length() < 1) "SELECT * FROM MY_TABLE"
                                  else "SELECT * FROM MY_TABLE WHERE book LIKE '${et_bookName.text}'",null)
            c.moveToFirst()
            item.clear()
            Toast.makeText(this@MainActivity,"共有${c.count}筆資料",Toast.LENGTH_SHORT).show()

            for(i in 0 until  c.count)
            {
                item.add("書名:${c.getString(0)} \t\t\t 價格: ${c.getString(1)}")
                c.moveToNext()
            }

            adapter.notifyDataSetChanged()
            c.close()
        }

        BtnAdd.setOnClickListener()
        {
            if(et_bookName.length() < 1)
                Toast.makeText(this@MainActivity,"欄位請物留空",Toast.LENGTH_SHORT)
            else
                try
                {
                    dbrw.execSQL("INSERT INTO MY_TABLE(book,price) VALUES(?,?)",
                    arrayOf<Any?>(et_bookName.text.toString(),et_price.text.toString()))

                    Toast.makeText(this@MainActivity,"新增書名 ${et_bookName.text}  價格: ${et_price.text}",Toast.LENGTH_SHORT).show()
                    et_bookName.setText("")
                    et_price.setText("")
                }
                catch ( e:Exception)
                {
                    Toast.makeText(this@MainActivity,"新增失敗: $e",Toast.LENGTH_SHORT).show()
                }
        }

        BtnModify.setOnClickListener()
        {
            if(et_bookName.length() < 1 || et_price.length() < 1)
                Toast.makeText(this@MainActivity,"更新書名${et_bookName.text} 價格: ${et_price.text}", Toast.LENGTH_SHORT).show()
            else
                try
                {
                    dbrw.execSQL("UPDATE MY_TABLE SET price = ${et_price.text} WHERE book = '${et_bookName.text}'")

                    Toast.makeText(this@MainActivity,"更新書名: ${et_bookName.text} 價格: ${et_price.text}",Toast.LENGTH_SHORT).show()
                    et_bookName.setText("")
                    et_price.setText("")
                }
                catch ( e: Exception)
                {
                    Toast.makeText(this@MainActivity,"更新失敗:$e",Toast.LENGTH_SHORT).show()
                    Log.e("Awei","更新失敗:$e")
                }
        }

        BtnDelete.setOnClickListener()
        {
            if(et_bookName.length() < 1)
                Toast.makeText(this@MainActivity,"書名勿留空",Toast.LENGTH_SHORT).show()
            else
                try
                {
                    dbrw.execSQL("DELETE FROM MY_TABLE WHERE book LIKE '${et_bookName.text}'")
                    Toast.makeText(this@MainActivity,"刪除書名 ${et_bookName.text}",Toast.LENGTH_SHORT).show()

                    et_bookName.setText("")
                    et_price.setText("")
                }
                catch ( e: Exception)
                {
                    Toast.makeText(this@MainActivity,"刪除失敗:$e",Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbrw.close()
    }
}