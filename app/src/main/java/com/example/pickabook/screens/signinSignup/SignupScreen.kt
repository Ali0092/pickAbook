package com.example.pickabook.screens.signinSignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentSignupScreenBinding


class SignupScreen : Fragment() {

    private lateinit var binding: FragmentSignupScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignupScreenBinding.inflate(layoutInflater)

         return binding.root
    }

}