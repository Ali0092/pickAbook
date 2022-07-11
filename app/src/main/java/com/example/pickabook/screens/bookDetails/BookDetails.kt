package com.example.pickabook.screens.bookDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentBookDetailsBinding
import com.example.pickabook.screens.listOfBooks.BookListScreenDirections

class BookDetails : Fragment() {

    private lateinit var binding: FragmentBookDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentBookDetailsBinding.inflate(layoutInflater)

        return binding.root
    }


}