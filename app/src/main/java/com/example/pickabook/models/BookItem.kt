package com.example.pickabook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookItem(
    val title:String="",
    val author:String="",
    val status:String="",
    val link:String="",
    val price:String=""
):Parcelable
