package com.example.pickabook.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pickabook.models.Category
import java.lang.IllegalArgumentException
import java.util.*


class BookListViewModelFactory(private val cat:Category):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookListViewModel::class.java)){
            return  BookListViewModel(cat) as T
        }
        throw IllegalArgumentException("Invalid Arguments....")
    }
}