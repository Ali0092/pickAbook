package com.example.pickabook.screens.listOfBooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentBookListScreenBinding

class BookListScreen : Fragment() {

    private lateinit var binding: FragmentBookListScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentBookListScreenBinding.inflate(layoutInflater)

       return binding.root
    }


}