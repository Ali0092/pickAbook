package com.example.pickabook.screens.listOfBooks

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.R
import com.example.pickabook.databinding.GridViewItemBinding
import com.example.pickabook.models.BookItem
import com.example.pickabook.models.BookStore
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class BookListAdapter() : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    var bookList = emptyList<BookStore>()
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
        val currentItem=bookList[position]
        holder.binding.apply {
            CoroutineScope(Dispatchers.Main).launch {
                Picasso.get().load(currentItem.id)
                nameTv.text=currentItem.name.toString()
            }
        }
       /* holder.binding.gridLayout.setOnClickListener {
                it.findNavController().navigate(R.id.action_fictionScreen_to_bookListScreen)
        }
        */

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getBookListItems(list: List<BookStore>){
        this.bookList=list
      //  this.cat=cat
        this.notifyDataSetChanged()
    }
}