package com.example.pickabook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.models.BookItem

class BookDetailsViewModel:ViewModel() {

    private val _data=MutableLiveData<BookItem>()
    val data:LiveData<BookItem>
    get() = _data

    fun getTheArgs(details:BookItem){
        _data.postValue(details)
    }
}