package com.example.pickabook.screens.fiction_nonfiction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickabook.databinding.FragmentFictionScreenBinding
import com.example.pickabook.viewModel.FictionNonFictionViewModel


class FictionNonFictionScreen : Fragment() {

    private lateinit var binding: FragmentFictionScreenBinding
    private val viewModel by lazy { FictionNonFictionViewModel() }
    private val myAdapter by lazy{ FictionNonFictionAdapter() }
    private val args:FictionNonFictionScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFictionScreenBinding.inflate(layoutInflater)
        settingUpRecyclerView()
        viewModel.setCategory(args.type)
        myAdapter.setCategory(args.type)
        viewModel.getAllTheCats()

        binding.bookType.text=args.type.toString()
        viewModel.data.observe(viewLifecycleOwner, Observer {
           myAdapter.setData(it)
        })

        return binding.root
    }

   private fun settingUpRecyclerView(){
       binding.recView.adapter=myAdapter
       binding.recView.layoutManager= GridLayoutManager(context,2)
   }
}