package com.example.pickabook.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookDetails(
    val author:String="",
    val link:String="",
    val price:String="",
    val status:String="",
    val title:String=""
):Parcelable
