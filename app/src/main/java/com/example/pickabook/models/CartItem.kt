package com.example.pickabook.models

data class CartItem(
    val imageLink:String=" ",
    val id:Long=0,
    val title:String=" ",
    val cost:Long=1,
    var quantity:Int=1
)
