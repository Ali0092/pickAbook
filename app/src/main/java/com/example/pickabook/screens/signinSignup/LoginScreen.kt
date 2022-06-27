package com.example.pickabook.screens.signinSignup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {

private lateinit var binding:FragmentLoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentLoginScreenBinding.inflate(layoutInflater)

        return binding.root
    }

}