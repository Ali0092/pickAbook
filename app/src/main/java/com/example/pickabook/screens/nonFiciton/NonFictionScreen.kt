package com.example.pickabook.screens.nonFiciton

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pickabook.DataUtils
import com.example.pickabook.screens.categoryScreen.CategoriesAdapter
import com.example.pickabook.databinding.FragmentNonFictionScreenBinding

class NonFictionScreen : Fragment() {

    private lateinit var binding:FragmentNonFictionScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNonFictionScreenBinding.inflate(layoutInflater)

        val adapter= CategoriesAdapter()
        adapter.CategoriesAdapter(this.requireContext(),DataUtils.nonFictionCategory)
        binding.nfGridGv.adapter=adapter

        binding.nfGridGv.setOnItemClickListener { adapterView, view, i, l ->
          val item=DataUtils.nonFictionCategory[i]
        /*  this.findNavController().navigate(
              NonFictionScreenDirections.actionNonFictionScreenToCheckScreen(
                  item.name
              )
          )

         */
        }

        return binding.root
    }

}