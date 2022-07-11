package com.example.pickabook.screens.fiction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pickabook.DataUtils
import com.example.pickabook.screens.categoryScreen.CategoriesAdapter
import com.example.pickabook.databinding.FragmentFictionScreenBinding


class FictionScreen : Fragment() {

    private lateinit var binding: FragmentFictionScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFictionScreenBinding.inflate(layoutInflater)

        val adapter = CategoriesAdapter()
        adapter.CategoriesAdapter(this.requireContext(), DataUtils.fictionCategory)
        binding.fGridGv.adapter = adapter



        binding.fGridGv.setOnItemClickListener { parent, v, position, id ->
            val item = DataUtils.fictionCategory[position]
            this.findNavController().navigate(FictionScreenDirections.actionFictionScreenToBookListScreen("Fiction",item.name.toString()))
        }



        return binding.root
    }


}