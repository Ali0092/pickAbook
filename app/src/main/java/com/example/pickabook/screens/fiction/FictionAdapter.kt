package com.example.pickabook.screens.fiction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.GridViewItemBinding
import com.example.pickabook.models.BookCatTitle
import com.squareup.picasso.Picasso

class FictionAdapter : RecyclerView.Adapter<FictionAdapter.MyViewHolder>() {

    private var list = emptyList<BookCatTitle>()

    class MyViewHolder(val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //ViewHolder Class...
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            GridViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            Picasso.get().load(list[position].link).into(this.imgIv)
            this.nameTv.text = list[position].name.toString()
        }
        holder.binding.gridLayout.setOnClickListener {
            //Navigate From Fiction to BookList
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(newList: List<BookCatTitle>) {
        val diffutils=FictionDiffutils(list,newList)
        val diffResult=DiffUtil.calculateDiff(diffutils)
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

}