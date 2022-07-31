package com.example.pickabook.screens.cart

import androidx.recyclerview.widget.DiffUtil
import com.example.pickabook.models.CartItem

class CartScreenDiffutils(
    private val oldList:List<CartItem>,
    private val newList:List<CartItem>
):DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int =newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
         return oldList[oldItemPosition].title==newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
     return when{
         oldList[oldItemPosition].title!=newList[newItemPosition].title ->  false
         oldList[oldItemPosition].imageLink!=newList[newItemPosition].imageLink ->  false
         else -> true
     }
    }

}