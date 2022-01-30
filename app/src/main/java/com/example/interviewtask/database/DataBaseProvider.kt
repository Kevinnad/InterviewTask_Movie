package com.example.interviewtask.database

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class DataBaseProvider @Inject constructor(val context: Context) {
        /* Build Data base*/
    fun createDB() : MovieDataBase{

        return Room.databaseBuilder(
            context,
            MovieDataBase::class.java, "movie-database"
        ).build()

    }
}