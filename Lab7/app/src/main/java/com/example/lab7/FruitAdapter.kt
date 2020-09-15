package com.example.lab7

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.layout_gridview.view.*

class FruitAdapter constructor(private val layout: Int,
                               private val data: ArrayList<MainActivity.Item>): BaseAdapter()
{
    override fun getCount() = data.size
    override fun getItem(idx: Int) = data[idx]
    override fun getItemId(idx:Int) = 0L

    override fun getView(idx:Int, convertView: View?, parent: ViewGroup?) :View
    {
        val view = View.inflate(parent?.context, layout, null)
        view.img_photo.setImageResource(data[idx].idx_img)
        view.tv_name.text = data[idx].name
        return view
    }
}