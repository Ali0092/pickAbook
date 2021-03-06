package com.example.pickabook

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DataUtils {

    val BookStore = Firebase.firestore.collection("BookStore")
    val Category = Firebase.firestore.collection("Category")
    val Cart = Firebase.firestore.collection("CartItems")
    val Favourites = Firebase.firestore.collection("FavouriteItems")

    const val fictionCode: Long = 1
    const val nonFictionCode: Long = 2
    const val cartIds = 300
    const val favIds = 400

}