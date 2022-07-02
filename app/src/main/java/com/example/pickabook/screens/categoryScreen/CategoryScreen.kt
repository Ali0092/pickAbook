package com.example.pickabook.screens.categoryScreen

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.pickabook.DataUtils.PICK_IMAGE_REQUEST
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCategoryScreenBinding
import com.example.pickabook.viewModel.CategoryViewModel
import java.net.URI

class CategoryScreen : Fragment() {

    private lateinit var binding: FragmentCategoryScreenBinding
    private val vm: CategoryViewModel by viewModels()
    private var filePath: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryScreenBinding.inflate(layoutInflater)

        binding.pickImage.setOnClickListener {
            imageContract.launch("image/*")
        }
        binding.upload.setOnClickListener {
            if(filePath!=null){
                vm.uploadImage(filePath!!)
            }
        }
        binding.fictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_fictionScreen)
        }
        binding.nonFictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_nonFictionScreen)
        }
        return binding.root
    }

    val imageContract=registerForActivityResult(ActivityResultContracts.GetContent()){ uri->
        uri?.let {
            filePath=it
        }
    }

}
