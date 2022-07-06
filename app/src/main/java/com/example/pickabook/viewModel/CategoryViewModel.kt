package com.example.pickabook.viewModel


import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookItem
import com.example.pickabook.models.BookStore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class CategoryViewModel : ViewModel() {

    private val store = DataUtils.BookStore.document("Fiction").collection("Action")
    private val storage = DataUtils.storage

    fun uploadImage(uri: Uri) = CoroutineScope(Dispatchers.IO).launch {
        try {
            storage.putFile(uri).await()
            withContext(Dispatchers.Main) {
                Log.d("testing", "Successfully Uploaded")
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.d("testing", e.message.toString())
            }
        }
    }


    fun storeData(data: BookStore) = CoroutineScope(Dispatchers.IO).launch {
        try {
            store.add(data).await()
            withContext(Dispatchers.Main) {
                Log.d("Testing", "Data added")
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.d("Testing", e.message.toString())
            }
        }
    }

    fun listOfDocs() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = store.get().await()

            for (docs in querySnapshot.documents) {
                val data= docs.toObject<BookItem>()
                val singleItem= data?.let { BookItem(it.title,it.author,it.status,it.link,it.price.toString()) }

                withContext(Dispatchers.Main) {
                    Log.d("Testing",singleItem.toString())
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Log.d("Testing", e.message.toString())
            }
        }
    }
}