package com.example.pickabook.screens.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentAboutAppBinding

class AboutApp : Fragment() {

    private lateinit var binding:FragmentAboutAppBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAboutAppBinding.inflate(layoutInflater)

        return binding.root
    }


}