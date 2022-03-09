package com.example.recipelist.ui
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.recipelist.R
import com.example.recipelist.data.Recipe
import com.squareup.picasso.Picasso

class RecipeAdapter(private val dataSource:ArrayList<Recipe> ): BaseAdapter() {

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val viewHolder : ViewHolder
        var content = view

        if(content == null)
        {
            content = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_recipe,parent,false)
            viewHolder = ViewHolder(content)
            content.tag = viewHolder
        }
        else
        {
            viewHolder = content.tag as ViewHolder
        }

        viewHolder.title.text = dataSource[position].title
        viewHolder.sub.text = dataSource[position].description
        viewHolder.lable.text = dataSource[position].label


        Picasso.get()
            .load(dataSource[position].imageUrl)
            .placeholder(R.mipmap.ic_launcher)
            .into(viewHolder.img)
        return content!!
    }

    private class ViewHolder(view:View){
        var img : ImageView = view.findViewById(R.id.recipe_list_thumbnail)
        var title:TextView = view.findViewById(R.id.recipe_list_title)
        var sub:TextView = view.findViewById(R.id.recipe_list_subtitle)
        val lable :TextView = view.findViewById(R.id.recipe_list_detail)
    }

}