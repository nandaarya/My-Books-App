package com.example.my_books_app

import android.os.Parcel
import android.os.Parcelable

data class Book(
    var bookCover: String,
    var bookTitle: String,
    var authorName: String,
    var publicationYear: String,
    var category: String,
    var synopsis: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bookCover)
        parcel.writeString(bookTitle)
        parcel.writeString(authorName)
        parcel.writeString(publicationYear)
        parcel.writeString(category)
        parcel.writeString(synopsis)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}