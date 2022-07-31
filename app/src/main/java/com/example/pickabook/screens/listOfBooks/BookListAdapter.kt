package com.example.pickabook.screens.listOfBooks

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.DataUtils
import com.example.pickabook.databinding.GridViewItemBinding
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.BookCatTitle
import com.squareup.picasso.Picasso

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    private var subCat=""
    private var oldList = emptyList<BookCatTitle>()
    private var bookDetailsList= emptyList<BookDetails>()

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
            Picasso.get().load(oldList[position].link).into(this.imgIv)
            this.nameTv.text = oldList[position].name.toString()
        }
        holder.binding.gridLayout.setOnClickListener {
           it.findNavController().navigate(BookListScreenDirections.actionBookListScreenToBookDetails(bookDetailsList[position],subCat))
        }


    }

    override fun getItemCount(): Int {
        return oldList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setBookData(newList: List<BookCatTitle>) {
        val diffUtils=BookListDiffUtils(oldList,newList)
        val diffResult=DiffUtil.calculateDiff(diffUtils)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }
    fun setBookDetailsList(list:List<BookDetails>,sCat:String){
        this.subCat=sCat
        this.bookDetailsList=list
    }
}