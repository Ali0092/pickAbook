package com.example.pickabook.screens.listOfBooks

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.GridViewItemBinding
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.BookTitle
import com.squareup.picasso.Picasso

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    private var bookList = emptyList<BookTitle>()
    private var bookDetailsList= emptyList<BookDetails>()
    //  var cat:String=" "

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
        val currentItem = bookList[position]
        holder.binding.apply {
            Picasso.get().load(currentItem.id).into(this.imgIv)
            this.nameTv.text = currentItem.name.toString()
        }
        holder.binding.gridLayout.setOnClickListener {
           it.findNavController().navigate(BookListScreenDirections.actionBookListScreenToBookDetails(bookDetailsList[position]))
        }


    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getBookListItems(list: List<BookTitle>) {
        this.bookList = list
        this.notifyDataSetChanged()
    }
    fun getBookDetailsList(list:List<BookDetails>){
        this.bookDetailsList=list
    }
}