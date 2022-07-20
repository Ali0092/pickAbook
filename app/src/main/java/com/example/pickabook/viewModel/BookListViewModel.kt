package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.BookCatTitle
import com.example.pickabook.models.Category
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookListViewModel(category: Category) : ViewModel() {

    private var store = DataUtils.BookStore.document(category.cat).collection(category.subCat)

    private val _details = MutableLiveData<List<BookDetails>>()
    val details: LiveData<List<BookDetails>>
        get() = _details

    //Have to try with SnapShot Listener...
    fun getAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val detailsList = mutableListOf<BookDetails>()

                store.addSnapshotListener { snapshot, error ->
                    if (error != null) {
                        Log.d("Tester", error.message.toString())
                        return@addSnapshotListener
                    }
                    if (snapshot != null) {
                        val dataList = snapshot.documents
                        for (doc in dataList) {
                            val dataItem = doc.toObject<BookDetails>()
                         //   Log.d("Tester",dataItem.toString())
                            if (dataItem != null) {
                                detailsList.add(dataItem)
                            }

                        }
                        _details.postValue(detailsList)

                    } else {
                        Log.d("Tester", "Data is null")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("Data List", e.message.toString())
                }
            }
        }
    }
}