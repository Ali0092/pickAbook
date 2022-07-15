package com.example.pickabook.screens.fiction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickabook.databinding.FragmentFictionScreenBinding
import com.example.pickabook.viewModel.FictionViewModel


class FictionScreen : Fragment() {

    private lateinit var binding: FragmentFictionScreenBinding
    private lateinit var viewModel:FictionViewModel
    private val myadapter by lazy { FictionAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFictionScreenBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this)[FictionViewModel::class.java]
        settingUpRecyclerView()
        viewModel.getAllTheCats()
        viewModel.data.observe(viewLifecycleOwner, Observer {
           myadapter.setData(it)
        })

        return binding.root
    }

   private fun settingUpRecyclerView(){
        binding.recView.layoutManager= GridLayoutManager(context,2)
        binding.recView.adapter=myadapter
   }
}