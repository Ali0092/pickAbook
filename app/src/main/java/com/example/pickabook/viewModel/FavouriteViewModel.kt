package com.example.pickabook.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookCatTitle
import com.example.pickabook.models.CartItem
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class FavouriteViewModel:ViewModel() {
    private val fireStoreRef= DataUtils.Favourites

    private val _dataList= MutableLiveData<List<BookCatTitle>>()
    val dataList: LiveData<List<BookCatTitle>>
        get() = _dataList

    fun getAllItems(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val tempList= mutableListOf<BookCatTitle>()

                val dataItems=fireStoreRef.get().await()

                for(doc in dataItems.documents){
                    doc.toObject<BookCatTitle>()?.let { tempList.add(it) }
                }
                _dataList.postValue(tempList)

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}