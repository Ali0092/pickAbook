package com.example.pickabook.models

data class CartItems(
    val imageLink:String,
    val title:String,
    val cost:Long,
    var quantity:Int=0
)
