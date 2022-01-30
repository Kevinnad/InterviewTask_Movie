package com.example.interviewtask.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.interviewtask.data.model.MovieModel

interface MovieRepository {
/*Get Paged Movie List from */
     fun getMovieList() : LiveData<PagedList<MovieModel>>

}