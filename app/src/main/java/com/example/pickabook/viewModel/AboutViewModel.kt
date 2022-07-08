package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookItem
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.math.sin

class AboutViewModel : ViewModel() {

    private val store = DataUtils.BookStore.document("Fiction").collection("Action")

    private val _data = MutableLiveData<MutableList<BookItem>>()
    val data: LiveData<MutableList<BookItem>>
        get() = _data


    fun getSingleData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val query = store.get().await()
                val list= mutableListOf<BookItem>()

                for (doc in query.documents) {
                    val dataItem = doc.toObject<BookItem>()
                    if(dataItem!=null){
                       list.add(dataItem)
                    }
                }
                _data.postValue(list)
                withContext(Dispatchers.Main){
                    Log.d("Tester", _data.value?.get(1)?.status.toString())
                }


            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("Data List", e.message.toString())
                }
            }
        }
    }

}