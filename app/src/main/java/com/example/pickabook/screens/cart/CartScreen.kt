package com.example.pickabook.screens.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCartScreenBinding

class CartScreen : Fragment() {

    private lateinit var binding: FragmentCartScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCartScreenBinding.inflate(layoutInflater)

        return binding.root
    }

}