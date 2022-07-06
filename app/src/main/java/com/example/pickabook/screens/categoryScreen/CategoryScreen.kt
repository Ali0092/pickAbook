package com.example.pickabook.screens.categoryScreen

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCategoryScreenBinding
import com.example.pickabook.viewModel.CategoryViewModel

class CategoryScreen : Fragment() {

    private lateinit var binding: FragmentCategoryScreenBinding
    private val vm: CategoryViewModel by viewModels()
    private var filePath: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryScreenBinding.inflate(layoutInflater)

        binding.upload.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_aboutApp)
        }
        binding.fictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_fictionScreen)
        }
        binding.nonFictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_nonFictionScreen)
        }
        return binding.root
    }

    val imageContract = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            filePath = it
        }
    }

}
