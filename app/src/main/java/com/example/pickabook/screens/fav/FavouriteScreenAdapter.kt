package com.example.pickabook.screens.fav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.FavItemViewBinding
import com.example.pickabook.models.BookCatTitle
import com.squareup.picasso.Picasso

class FavouriteScreenAdapter : RecyclerView.Adapter<FavouriteScreenAdapter.MyViewHolder>() {

    private var oldList = emptyList<BookCatTitle>()

    class MyViewHolder(val binding: FavItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        //MyViewHolder....
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FavItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            Picasso.get().load(oldList[position].link).into(bookImage)
            bookTitle.text = oldList[position].name.toString()
        }
    }

    override fun getItemCount(): Int = oldList.size


    fun setData(newList: List<BookCatTitle>) {
        val diffutils = FavouriteScreenDiffUtils(oldList, newList)
        val diffResults = DiffUtil.calculateDiff(diffutils)
        oldList = newList
        diffResults.dispatchUpdatesTo(this)
    }
}