package com.example.pickabook.viewModel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pickabook.DataUtils
import com.example.pickabook.models.BookCatTitle
import com.example.pickabook.models.BookDetails
import com.example.pickabook.models.CartItem
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class BookDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val cartFirestoreRef = DataUtils.Cart
    private val favFirestoreRef = DataUtils.Favourites

    private val _data = MutableLiveData<BookDetails>()
    val data: LiveData<BookDetails>
        get() = _data


    fun getTheArgs(details: BookDetails) {
        _data.postValue(details)
    }

    private fun setTheCartItem(item: CartItem) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                cartFirestoreRef.add(item).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        getApplication(),
                        "Data Successfully Added...",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(getApplication(), e.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

    }

    private fun setTheFavItem(item: BookCatTitle) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                favFirestoreRef.add(item).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        getApplication(),
                        "Data Successfully Added...",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(getApplication(), e.message.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun checkingCartData(data: CartItem) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dataList = cartFirestoreRef.get().await()
                var checkFlag = false
                for (docs in dataList.documents) {
                    val temp = docs.toObject<CartItem>()
                    if (temp?.id == data.id) {
                        checkFlag = true
                    }
                }
                if (!checkFlag) {
                    setTheCartItem(data)
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            getApplication(),
                            "Data Already Exists...",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } catch (e: Exception) {
                Log.wtf("TF", e.message.toString())
            }
        }
    }

    fun checkingFavData(data: BookCatTitle) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val dataList = favFirestoreRef.get().await()
                var checkFlag = false
                for (docs in dataList.documents) {
                    val temp = docs.toObject<CartItem>()
                    if (temp?.id == data.id) {
                        checkFlag = true
                    }
                }
                if (!checkFlag) {
                    setTheFavItem(data)
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            getApplication(),
                            "Data Already Exists...",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } catch (e: Exception) {
                Log.wtf("TF", e.message.toString())
            }
        }
    }

}