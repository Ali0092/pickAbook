package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookItem
import com.example.pickabook.models.BookStore
import com.example.pickabook.models.Category
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BookListViewModel(category: Category) {

    private var store:CollectionReference

    private val _data = MutableLiveData<List<BookStore>>()
    val data: LiveData<List<BookStore>>
        get() = _data

    init {
        store = DataUtils.BookStore.document(category.cat).collection(category.subCat)
    }

    fun getAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val query = store.get().await()
                val list= mutableListOf<BookStore>()

                for (doc in query.documents) {
                    val dataItem = doc.toObject<BookItem>()
                    if(dataItem!=null){
                        val temp=BookStore(dataItem.title.toString(),dataItem.link)
                        list.add(temp)
                    }
                }
                _data.postValue(list)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("Data List", e.message.toString())
                }
            }
        }
    }
}