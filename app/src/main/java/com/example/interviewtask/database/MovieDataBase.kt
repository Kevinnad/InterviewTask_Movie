package com.example.interviewtask.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.interviewtask.data.model.MovieModel

@Database(entities = [MovieModel::class], version = 1)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun formDao() : MovieDao
}