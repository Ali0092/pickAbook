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

class FictionNonFictionViewModel : ViewModel() {

    private val fireStoreRef = DataUtils.Category

    private val _data = MutableLiveData<List<BookCatTitle>>()
    val data: LiveData<List<BookCatTitle>>
        get() = _data

    private var type:String=" "

    fun setCategory(data:String){
        type=data
    }

    fun getAllTheCats() = CoroutineScope(Dispatchers.IO).launch {
        try {
            var temp:Long=0
            temp = if(type=="Fiction"){
                DataUtils.fictionCode
            }else{
                DataUtils.nonFictionCode
            }
            val snapShotDocs =
                fireStoreRef.whereEqualTo("id", temp).get().await()
            val list = mutableListOf<BookCatTitle>()
            for (docs in snapShotDocs.documents) {
                val doc = docs.toObject<BookCatTitle>()
                if (doc != null) {
                    list.add(doc)
                    withContext(Dispatchers.Main) {
                        Log.d("temp", doc.toString())
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