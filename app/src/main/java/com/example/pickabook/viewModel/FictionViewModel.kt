package com.example.pickabook.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookCatTitle
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class FictionViewModel : ViewModel() {

    private val fireStoreRef = DataUtils.Category

    private val _data = MutableLiveData<List<BookCatTitle>>()
    val data: LiveData<List<BookCatTitle>>
        get() = _data

    fun getAllTheCats() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val snapShotDocs =
                fireStoreRef.whereEqualTo("id", DataUtils.fictionCode).get().await()
            val list = mutableListOf<BookCatTitle>()
            for (docs in snapShotDocs.documents) {
                val temp = docs.toObject<BookCatTitle>()
                if (temp != null) {
                    list.add(temp)
                    withContext(Dispatchers.Main) {
                        Log.d("temp", temp.toString())
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        Log.d("Tester", "Data is Null....")
                    }
                }
            }
            _data.postValue(list)

        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.d("Tester", e.message.toString())
            }
        }
    }

}