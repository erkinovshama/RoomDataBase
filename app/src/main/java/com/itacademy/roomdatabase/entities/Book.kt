package com.itacademy.roomdatabase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Genre::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("genreID"))])
data class Book (
    @PrimaryKey (autoGenerate = true) val idBook: Int?,
    @ColumnInfo(name = "bookName") var bookName: String?,
    @ColumnInfo(name = "author") var author: String?,
    @ColumnInfo(name = "publicationDate") var date: String?,
    @ColumnInfo(name = "pageAmount") var pageAmount: Int?,
    @ColumnInfo(name = "amount") var amount: Int?,
    @ColumnInfo(name = "place") var place: String?,
    @ColumnInfo(name = "genreID") var genreID: Int?
)


@Entity
data class Genre (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "genreName") var name: String
)
