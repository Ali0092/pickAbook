package com.example.pickabook.screens.fav

import androidx.recyclerview.widget.DiffUtil
import com.example.pickabook.models.BookCatTitle

class FavouriteScreenDiffUtils(
    private val oldList:List<BookCatTitle>,
    private val newList:List<BookCatTitle>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name==newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
      return when{
          oldList[oldItemPosition].name!=newList[newItemPosition].name -> false
          oldList[oldItemPosition].link!=newList[newItemPosition].link -> false
          else -> true
      }
    }
}