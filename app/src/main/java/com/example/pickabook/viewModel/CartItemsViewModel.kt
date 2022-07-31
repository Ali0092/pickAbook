package com.example.pickabook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.CartItem
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class CartItemsViewModel :ViewModel(){
    private val fireStoreRef=DataUtils.Cart

    private val _dataList=MutableLiveData<List<CartItem>>()
    val dataList:LiveData<List<CartItem>>
    get() = _dataList

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tempList= mutableListOf<CartItem>()

                val dataItems=fireStoreRef.get().await()

                for(doc in dataItems.documents){
                    doc.toObject<CartItem>()?.let { tempList.add(it) }
                }
                _dataList.postValue(tempList)

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}