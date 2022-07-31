package com.example.pickabook.screens.bookDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentBookDetailsBinding
import com.example.pickabook.models.CartItem
import com.example.pickabook.viewModel.BookDetailsViewModel
import com.squareup.picasso.Picasso

class BookDetails : Fragment() {

    private lateinit var binding: FragmentBookDetailsBinding
    private val viewModel: BookDetailsViewModel by viewModels()
    private val args: BookDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookDetailsBinding.inflate(layoutInflater)
        viewModel.getTheArgs(args.singleBook)

        viewModel.data.observe(viewLifecycleOwner, Observer {
            Picasso.get().load(it.link).into(binding.Image)
            binding.bookTitle.text = it.title.toString()
            binding.title2.text = it.title.toString()
            binding.authorName.text = it.author.toString()
            binding.price.text = it.price.toString()
            binding.status.text = it.status.toString()
        })

        binding.addToCart.setOnClickListener {
            val imageLink=args.singleBook.link.toString()
            val title=args.singleBook.title.toString()
            val cost=args.singleBook.price
            val quantity=1

            val cartItem=CartItem(imageLink,title,cost,quantity)

            viewModel.setTheCartItem(cartItem)
        }

        binding.addToFav.setOnClickListener {
            Toast.makeText(context,"Added into FAV List..:)",Toast.LENGTH_LONG).show()
        }
        return binding.root
    }


}

