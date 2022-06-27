package com.example.pickabook.screens.categoryScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pickabook.DataUtils
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentCategoryScreenBinding
import com.example.pickabook.models.BookStore
import com.example.pickabook.models.CatItem
import com.example.pickabook.viewModel.CategoryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CategoryScreen : Fragment() {

    private lateinit var binding:FragmentCategoryScreenBinding
    private val vm:CategoryViewModel  by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCategoryScreenBinding.inflate(layoutInflater)


     //   val data1=BookStore("temp1","1")
      //  val data2=BookStore("temp2","2")

      //  vm.tempo(data1)
            // vm.tempo(data2)

        vm.listOfDocs()


        binding.fictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_fictionScreen)
        }
        binding.nonFictionBtn.setOnClickListener {
            this.findNavController().navigate(R.id.action_categoryScreen_to_nonFictionScreen)
        }
        return binding.root
    }

}