package com.itacademy.roomdatabase.dao

import androidx.room.*
import com.itacademy.roomdatabase.entities.Book

@Dao
interface BookDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun addBook(vararg book: Book)

        @Query("SELECT * FROM Book")
        fun getAllBooks(): Array<Book>

        @Delete
        fun delBook(book: Book)
}