package com.example.pickabook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.models.BookDetails

class BookDetailsViewModel:ViewModel() {

    private val _data=MutableLiveData<BookDetails>()
    val data:LiveData<BookDetails>
    get() = _data

    fun getTheArgs(details:BookDetails){
        _data.postValue(details)
    }
}