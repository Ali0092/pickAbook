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
import java.lang.Exception

class AboutViewModel:ViewModel() {

    private val store=DataUtils.BookStore.document("Fiction").collection("Action")

    private val _data= MutableLiveData<MutableList<BookItem>>()
    val data:LiveData<MutableList<BookItem>>
    get() = _data

    fun getSingleData(){
         CoroutineScope(Dispatchers.IO).launch {
             try {
               val query=store.get().await()
                 for (doc in query.documents){
                     val data= doc.toObject<BookItem>()
                     val singleItem= data?.let { BookItem(it.title,it.author,it.status,it.link,it.price.toString()) }
                     if (singleItem != null) {
                         _data.value?.add(singleItem)
                     }
                     withContext(Dispatchers.Main){
                         Log.d("Data List","Data Added...")
                     }
                 }
             }catch (e:Exception){
                 withContext(Dispatchers.Main){
                     Log.d("Data List",e.message.toString())
                 }
             }
         }
    }

}