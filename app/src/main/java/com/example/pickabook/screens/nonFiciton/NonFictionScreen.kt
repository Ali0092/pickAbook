package com.example.pickabook.screens.nonFiciton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.pickabook.DataUtils
import com.example.pickabook.databinding.FragmentNonFictionScreenBinding

class NonFictionScreen : Fragment() {

    private lateinit var binding:FragmentNonFictionScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNonFictionScreenBinding.inflate(layoutInflater)

        return binding.root
    }

}