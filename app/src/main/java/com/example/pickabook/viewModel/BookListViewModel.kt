package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.BookTitle
import com.example.pickabook.models.Category
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BookListViewModel(category: Category):ViewModel() {

    private var store = DataUtils.BookStore.document(category.cat).collection(category.subCat)

    private val _data = MutableLiveData<List<BookTitle>>()
    val data: LiveData<List<BookTitle>>
        get() = _data

    private val _details = MutableLiveData<List<BookDetails>>()
    val details: LiveData<List<BookDetails>>
        get() = _details

    fun getAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val query = store.get().await()
                val list= mutableListOf<BookTitle>()
                val listWithDetails= mutableListOf<BookDetails>()

                for (doc in query.documents) {
                    val dataItem = doc.toObject<BookDetails>()
                    if(dataItem!=null){
                        val temp=BookTitle(dataItem.title.toString(),dataItem.link)
                        listWithDetails.add(dataItem)
                        list.add(temp)
                    }
                }
                _data.postValue(list)
                _details.postValue(listWithDetails)
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("Data List", e.message.toString())
                }
            }
        }
    }
}