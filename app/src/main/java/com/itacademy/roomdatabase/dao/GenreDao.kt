package com.itacademy.roomdatabase.dao

import androidx.room.*
import com.itacademy.roomdatabase.entities.Genre

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addGenre(vararg genre: Genre)

    @Query("SELECT * FROM Genre")
    fun getAllGenre(): List<Genre>

    @Query("SELECT genreName FROM Genre")
    fun getNameGenre(): List<String>

    @Query("SELECT id FROM Genre")
    fun getIdGenre():List<Int>

    @Delete
    fun deleteGenre(genre: Genre)

    @Update
    fun updateGenre(genre: Genre)
}