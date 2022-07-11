package com.example.pickabook

import com.example.pickabook.models.BookTitle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DataUtils {
    val BookStore= Firebase.firestore.collection("BookStore")
        //  val storage=FirebaseStorage.getInstance().getReference("bookImages/")

    val fictionCategory = arrayOf(

        BookTitle( "Action",R.drawable.action_adventure.toString()),
        BookTitle( "History",R.drawable.alternate_history.toString()),
        BookTitle( "Crime",R.drawable.crime_.toString()),
        BookTitle( "Drama",R.drawable.drama.toString()),
        BookTitle("Fantasy",R.drawable.fantasy.toString()),
        BookTitle("Horror",R.drawable.horror.toString() ),
        BookTitle("Mystery",R.drawable.mystery.toString() ),
        BookTitle("Poetry",R.drawable.poetry.toString() ),
        BookTitle("Sci-Fi",R.drawable.sci_fi.toString()),
        BookTitle("Adult",R.drawable.y_adult.toString())
    )

    val nonFictionCategory=arrayOf(
        BookTitle("Art",R.drawable.art.toString()),
        BookTitle("Autobiography",R.drawable.auto.toString()),
        BookTitle("Story",R.drawable.story.toString()),
        BookTitle("Encyclopedia",R.drawable.encyclopedia.toString()),
        BookTitle("Guide",R.drawable.guide.toString()),
        BookTitle("History",R.drawable.history.toString()),
        BookTitle("Philosophy",R.drawable.philosophy.toString())
    )
}