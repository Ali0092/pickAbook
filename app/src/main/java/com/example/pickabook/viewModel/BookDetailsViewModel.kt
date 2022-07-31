package com.example.pickabook.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.CartItem
import io.grpc.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BookDetailsViewModel(application: Application):AndroidViewModel(application) {

    private val fireStoreRef=DataUtils.Cart

    private val _data=MutableLiveData<BookDetails>()
    val data:LiveData<BookDetails>
    get() = _data


    fun getTheArgs(details:BookDetails){
        _data.postValue(details)
    }

    fun setTheCartItem(item:CartItem){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                fireStoreRef.add(item).await()
                withContext(Dispatchers.Main){
                  Toast.makeText(getApplication(),"Data Successfully Added...",Toast.LENGTH_LONG).show()
                }
            }catch (e:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(getApplication(),e.message.toString(),Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}