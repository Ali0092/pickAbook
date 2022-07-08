package com.example.pickabook.screens.listOfBooks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pickabook.R
import com.example.pickabook.databinding.FragmentBookListScreenBinding
import com.example.pickabook.models.BookStore
import com.example.pickabook.screens.categoryScreen.CategoriesAdapter

class BookListScreen : Fragment() {

    private lateinit var binding: FragmentBookListScreenBinding
    private lateinit var bookListAdapter: BookListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding= FragmentBookListScreenBinding.inflate(layoutInflater)

       return binding.root
    }

    fun settingUpRecyclerView(list:List<BookStore>,cat:String){
       bookListAdapter= BookListAdapter()
       bookListAdapter.getBookListItems(list,cat)
       binding.revView.adapter=bookListAdapter
       binding.revView.layoutManager=GridLayoutManager(context,2)
    }


}