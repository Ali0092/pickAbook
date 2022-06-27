package com.example.pickabook.screens.fav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentFavouriteScreenBinding

class FavouriteScreen : Fragment() {

    private lateinit var binding:FragmentFavouriteScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFavouriteScreenBinding.inflate(layoutInflater)

        return binding.root
    }


}