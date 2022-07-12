package com.example.pickabook.screens.listOfBooks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickabook.databinding.FragmentBookListScreenBinding
import com.example.pickabook.models.Category
import com.example.pickabook.viewModel.BookListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListScreen : Fragment() {

    private lateinit var binding: FragmentBookListScreenBinding
    private lateinit var bookListAdapter: BookListAdapter
    private lateinit var bookListViewModel: BookListViewModel
    private val args: BookListScreenArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookListScreenBinding.inflate(layoutInflater)
        settingUpRecyclerView()
        val bookCategory = Category(args.cat, args.subCat)
        bookListViewModel = BookListViewModel(bookCategory)

        bookListViewModel.getAllData()

        bookListViewModel.data.observe(viewLifecycleOwner, Observer {
            bookListAdapter.getBookListItems(it)
        })
        bookListViewModel.details.observe(viewLifecycleOwner, Observer {
              bookListAdapter.getBookDetailsList(it)
        })

        return binding.root
    }

    private fun settingUpRecyclerView() {
        bookListAdapter = BookListAdapter()
        binding.revView.adapter = bookListAdapter
        binding.revView.layoutManager = GridLayoutManager(context, 2)
    }


}