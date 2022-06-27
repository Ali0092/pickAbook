package com.example.pickabook.screens.categoryScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pickabook.R
import com.example.pickabook.models.CatItem


class CategoriesAdapter() : BaseAdapter() {

    private var mContext: Context? = null
    private var catArray= emptyArray<CatItem>()

    fun CategoriesAdapter(c: Context?,cArray:Array<CatItem>) {
        mContext = c
        catArray=cArray
    }

    override fun getCount(): Int {
        return catArray.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listViewItem = convertView

        if (listViewItem == null) {
            listViewItem =
                LayoutInflater.from(mContext).inflate(R.layout.grid_view_item, parent, false)
        }

        listViewItem!!.findViewById<TextView>(R.id.name_tv).setText(catArray[position].name)
        listViewItem.findViewById<ImageView>(R.id.img_iv).setImageResource(catArray[position].img)

        return listViewItem
    }

}