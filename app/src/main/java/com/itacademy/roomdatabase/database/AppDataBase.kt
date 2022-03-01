package com.itacademy.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itacademy.roomdatabase.dao.BookDao
import com.itacademy.roomdatabase.dao.GenreDao
import com.itacademy.roomdatabase.entities.Book
import com.itacademy.roomdatabase.entities.Genre

@Database(entities = [Book::class, Genre::class], version = 9, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun genreDao(): GenreDao

}

