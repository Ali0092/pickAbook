package com.example.pickabook

import com.example.pickabook.models.CatItem
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

object DataUtils {
    val BookStore= Firebase.firestore.collection("BookStore")
    val storage=FirebaseStorage.getInstance().getReference("bookImages/")
    val PICK_IMAGE_REQUEST=22

    val fictionCategory = arrayOf(
        CatItem(R.drawable.action_adventure, "Action"),
        CatItem(R.drawable.alternate_history, "History"),
        CatItem(R.drawable.crime_, "Crime"),
        CatItem(R.drawable.drama, "Drama"),
        CatItem(R.drawable.fantasy, "Fantasy"),
        CatItem(R.drawable.horror, "Horror"),
        CatItem(R.drawable.mystery, "Mystery"),
        CatItem(R.drawable.poetry, "Poetry"),
        CatItem(R.drawable.sci_fi, "Sci-Fi"),
        CatItem(R.drawable.y_adult, "Adult")
    )

    val nonFictionCategory=arrayOf(
        CatItem(R.drawable.art,"Art"),
        CatItem(R.drawable.auto,"Autobiography"),
        CatItem(R.drawable.story,"Story"),
        CatItem(R.drawable.encyclopedia,"Encyclopedia"),
        CatItem(R.drawable.guide,"Guide"),
        CatItem(R.drawable.history,"History"),
        CatItem(R.drawable.philosophy,"Philosophy")
    )
}