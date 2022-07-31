package com.example.pickabook

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DataUtils {

    val BookStore = Firebase.firestore.collection("BookStore")
    val Category=Firebase.firestore.collection("Category")
    val Cart=Firebase.firestore.collection("CartItems")
    const val fictionCode:Long=1
    const val nonFictionCode:Long=2

}