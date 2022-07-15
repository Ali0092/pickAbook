package com.example.pickabook.screens.categoryScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCategoryScreenBinding

class CategoryScreen : Fragment() {

    private lateinit var binding: FragmentCategoryScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryScreenBinding.inflate(layoutInflater)

        binding.fictionBtn.setOnClickListener {
            this.findNavController().navigate(
                CategoryScreenDirections.actionCategoryScreenToFictionNonFictionScreen("Fiction")
            )
        }
        binding.nonFictionBtn.setOnClickListener {
            this.findNavController().navigate(
                CategoryScreenDirections.actionCategoryScreenToFictionNonFictionScreen("NonFiction")
            )
        }
        return binding.root
    }

}
