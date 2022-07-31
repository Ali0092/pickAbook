package com.example.pickabook.screens.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCartScreenBinding
import com.example.pickabook.viewModel.CartItemsViewModel

class CartScreen : Fragment() {

    private lateinit var binding: FragmentCartScreenBinding
    private val myAdapter by lazy { CartScreenAdapter() }
    private val myViewModel by viewModels<CartItemsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCartScreenBinding.inflate(layoutInflater)
        settingUpRecyclerView()

        myViewModel.getAllItems()

        myViewModel.dataList.observe(viewLifecycleOwner) { itemsList ->
            myAdapter.setData(itemsList)
        }


        return binding.root
    }

    private fun settingUpRecyclerView(){
        binding.recView.adapter=myAdapter
        binding.recView.layoutManager=LinearLayoutManager(context)
    }
}