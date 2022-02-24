package com.example.lab8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val contacts: ArrayList<MainActivity.Contact>):
    RecyclerView.Adapter<ListAdapter.ViewHolder>()
{
    class ViewHolder(v: View): RecyclerView.ViewHolder(v)
    {
        val tv_name = v.findViewById<TextView>(R.id.tv_name)
        val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
        val img_del = v.findViewById<ImageView>(R.id.img_del)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
                    inflate(R.layout.layout_list_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = contacts[position].name
        holder.tv_phone.text = contacts[position].phone

        holder.img_del.setOnClickListener()
        {
            contacts.removeAt(position)
            notifyDataSetChanged()
        }
    }
}