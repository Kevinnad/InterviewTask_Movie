package com.example.interviewtask.data.datastore

import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.network.ResultWrapper

interface MovieDataStore {

    suspend fun getMovieList(pageNumber: Int): ResultWrapper<List<MovieModel>>
}