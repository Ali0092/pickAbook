package com.example.pickabook.screens.fav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pickabook.databinding.FragmentFavouriteScreenBinding
import com.example.pickabook.viewModel.FavouriteViewModel

class FavouriteScreen : Fragment() {

    private lateinit var binding: FragmentFavouriteScreenBinding
    private val myAdapter by lazy { FavouriteScreenAdapter() }
    private val myViewModel by viewModels<FavouriteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteScreenBinding.inflate(layoutInflater)
        settingUpRecyclerView()

        myViewModel.getAllItems()

        myViewModel.dataList.observe(viewLifecycleOwner) {
            myAdapter.setData(it)
        }

        return binding.root
    }

    private fun settingUpRecyclerView() {
        binding.recView.adapter = myAdapter
        binding.recView.layoutManager = LinearLayoutManager(context)
    }


}