package com.example.pickabook.screens.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.pickabook.DataUtils
import com.example.pickabook.databinding.FragmentAboutAppBinding
import com.example.pickabook.viewModel.AboutViewModel
import com.squareup.picasso.Picasso

class AboutApp : Fragment() {

    private lateinit var binding: FragmentAboutAppBinding
    private val vm: AboutViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutAppBinding.inflate(layoutInflater)

        vm.getSingleData()
        vm.data.observe(viewLifecycleOwner, Observer {
          //  Glide.with(this).load(it[0].link).into(binding.Image)
            Picasso.get().load(it[0].link).into(binding.Image)
            binding.bookTitle.text = it[0].title.toString()
            binding.authorName.text = it[0].author.toString()
            binding.status.text = it[0].status.toString()
            binding.price.text = it[0].price.toString()
        })
        return binding.root
    }


}