package com.example.pickabook.screens.fiction_nonfiction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.GridViewItemBinding
import com.example.pickabook.models.BookCatTitle
import com.squareup.picasso.Picasso

class FictionNonFictionAdapter : RecyclerView.Adapter<FictionNonFictionAdapter.MyViewHolder>() {

    private var list = emptyList<BookCatTitle>()
    private var category: String = " "

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
            it.findNavController().navigate(
                FictionNonFictionScreenDirections.actionFictionNonFictionScreenToBookListScreen(
                    category,
                    list[position].name.toString()
            ))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setCategory(cat: String) {
        category = cat
    }

    fun setData(newList: List<BookCatTitle>) {
        val diffutils = FictionNonFictionDiffUtils(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffutils)
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }

}