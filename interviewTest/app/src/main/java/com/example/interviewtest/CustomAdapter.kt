package com.example.interviewtest

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(
    var itemModel:ArrayList<ItemModel>,
    var context: Context
) : BaseAdapter()
{
    var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return itemModel.size
    }

    override fun getItem(p0: Int): Any {
        return itemModel[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var view = view
        if(view == null)
        {
            view = layoutInflater.inflate(R.layout.list_item,viewGroup,false)
        }

        var tvItemName = view?.findViewById<TextView>(R.id.text)
        var tvItemBack = view?.findViewById<ImageView>(R.id.image)

        tvItemName?.text = itemModel[position].name


        if(itemModel[position].color == 0)
        {
            tvItemName?.setTextColor(Color.parseColor("#66C000"))
            tvItemBack?.setImageResource(R.drawable.rect_light_green)
        }
        else if(itemModel[position].color == 1)
        {
            tvItemName?.setTextColor(Color.parseColor("#0080FF"))
            tvItemBack?.setImageResource(R.drawable.rect_light_blue)
        }
        else
        {
            tvItemName?.setTextColor(Color.parseColor("#FF3333"))
            tvItemBack?.setImageResource(R.drawable.rect_light_red)
        }

        //tvItemBack?.setImageResource(itemModel[position].image!!)

        return view!!

    }

}