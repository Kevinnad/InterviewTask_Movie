package com.example.interviewtask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.interviewtask.data.model.MovieModel

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movieModelList: List<MovieModel>)

    @Query("SELECT * FROM moviemodel WHERE page IN(:page) ORDER BY releaseDate ")
    suspend fun getAll(page : Int) : List<MovieModel>?
}