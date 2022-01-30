package com.example.interviewtask.data.datastore

import androidx.paging.DataSource
import com.example.interviewtask.data.model.MovieModel

class MovieDataSourceFactory constructor(val dataStore: MovieDataStore): DataSource.Factory<Int, MovieModel>(){

    lateinit var moviePagingSource: MoviePagingSource

    override fun create(): DataSource<Int, MovieModel> {
        moviePagingSource = MoviePagingSource(dataStore)
        return  moviePagingSource
    }

}