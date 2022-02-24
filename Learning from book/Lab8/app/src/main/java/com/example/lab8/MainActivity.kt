package com.example.lab8

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    data class Contact
    (
        val name: String,
        val phone: String
    )

    private lateinit var adapter: ListAdapter
    private val contacts = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mlayoutManager = LinearLayoutManager(this)
        mlayoutManager.orientation = LinearLayoutManager.VERTICAL
        listView.layoutManager = mlayoutManager
        adapter = ListAdapter(contacts)
        listView.adapter = adapter

        BtnAdd.setOnClickListener()
        {
            startActivityForResult(Intent(this,UpdateActivity::class.java),1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val res = data?.extras?: return

        if(requestCode == Activity.RESULT_OK || requestCode == Activity.RESULT_FIRST_USER)
        {
            val strName = res.getString("name","") // "${res.get("name").toString()}"
            val strTel = res.getString("phone","") // "${res.get("phone").toString()}"
            val list = Contact(strName,strTel)
            contacts.add(list)
            adapter.notifyDataSetChanged()
        }
    }
}