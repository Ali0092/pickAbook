package com.example.pickabook.screens.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.CartItemViewBinding
import com.example.pickabook.models.CartItems
import com.squareup.picasso.Picasso

class CartScreenAdapter : RecyclerView.Adapter<CartScreenAdapter.MyViewHolder>() {

    private var oldList = emptyList<CartItems>()

    class MyViewHolder(val binding: CartItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        //ViewHolder Class....
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartScreenAdapter.MyViewHolder {
        return MyViewHolder(
            CartItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CartScreenAdapter.MyViewHolder, position: Int) {
        holder.binding.apply {
            Picasso.get().load(oldList[position].imageLink).into(Image)
            bookTitle.text = oldList[position].title
            cost.text = oldList[position].cost.toString()
            quantity.text = oldList[position].cost.toString()
        }
        holder.binding.quantity.setOnClickListener {
            oldList[position].quantity = oldList[position].quantity + 1
        }
        //Code to Delete the Item By Swiping...
    }

    override fun getItemCount(): Int = oldList.size

    fun setData(newList:List<CartItems>){
      val diffutils=CartScreenDiffutils(oldList,newList)
      val diffResults=DiffUtil.calculateDiff(diffutils)
      oldList=newList
        diffResults.dispatchUpdatesTo(this)
    }
}