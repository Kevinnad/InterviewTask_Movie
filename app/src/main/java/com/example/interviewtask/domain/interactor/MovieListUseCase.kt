package com.example.interviewtask.domain.interactor

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.interviewtask.data.model.MovieModel

interface MovieListUseCase {

    fun getMovieList() : LiveData<PagedList<MovieModel>>
}