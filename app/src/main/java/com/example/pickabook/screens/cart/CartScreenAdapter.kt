package com.example.pickabook.screens.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pickabook.databinding.CartItemViewBinding
import com.example.pickabook.models.CartItem
import com.squareup.picasso.Picasso

class CartScreenAdapter : RecyclerView.Adapter<CartScreenAdapter.MyViewHolder>() {

    private var oldList = emptyList<CartItem>()

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
            cost.text = "RS."+(oldList[position].cost).toString()
            quantity.text = oldList[position].quantity.toString()+"x"
        }
        //Code to Delete the Item By Swiping...
    }

    override fun getItemCount(): Int = oldList.size

    fun setData(newList:List<CartItem>){
      val diffutils=CartScreenDiffutils(oldList,newList)
      val diffResults=DiffUtil.calculateDiff(diffutils)
      oldList=newList
        diffResults.dispatchUpdatesTo(this)
    }
}