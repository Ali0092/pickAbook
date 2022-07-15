package com.example.pickabook.screens.listOfBooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickabook.databinding.FragmentBookListScreenBinding
import com.example.pickabook.models.BookCatTitle
import com.example.pickabook.models.Category
import com.example.pickabook.viewModel.BookListViewModel

class BookListScreen : Fragment() {

    private lateinit var binding: FragmentBookListScreenBinding
    private lateinit var bookListViewModel: BookListViewModel
    private val bookListAdapter by lazy { BookListAdapter() }
    private val args: BookListScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val listOfBookTitles= mutableListOf<BookCatTitle>()
        binding = FragmentBookListScreenBinding.inflate(layoutInflater)

        settingUpRecyclerView()

        val bookCategory = Category(args.cat, args.subCat)
        bookListViewModel = BookListViewModel(bookCategory)

        bookListViewModel.getAllData()

        bookListViewModel.details.observe(viewLifecycleOwner, Observer {
          for(data in it){
              val temp=BookCatTitle(0,data.link,data.title)
              listOfBookTitles.add(temp)
          }
          bookListAdapter.setBookData(listOfBookTitles)
          bookListAdapter.setBookDetailsList(it)
        })

        return binding.root
    }

    private fun settingUpRecyclerView() {
        binding.revView.adapter = bookListAdapter
        binding.revView.layoutManager = GridLayoutManager(context, 2)
    }


}