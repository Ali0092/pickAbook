package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookStore
import com.example.pickabook.models.CatItem
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CategoryViewModel:ViewModel() {

    private val store=DataUtils.BookStore.document("Fiction").collection("Horror")

    fun tempo(data:BookStore)= CoroutineScope(Dispatchers.IO).launch {
        try {
            store.add(data).await()
            withContext(Dispatchers.Main){
                Log.d("Testing","Data added")
            }
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Log.d("Testing",e.message.toString())
            }
        }
    }
    fun listOfDocs()= CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot=store.get().await()

            for(docs in querySnapshot.documents){
                withContext(Dispatchers.Main){
                  Log.d("Testing",docs.toObject<BookStore>()?.id.toString())
                }
            }
            withContext(Dispatchers.Main){
                Log.d("Testing","Message Displayed...")
            }
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                Log.d("Testing",e.message.toString())
            }
        }
    }
}