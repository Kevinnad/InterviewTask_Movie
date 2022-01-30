package com.example.interviewtask.presentation.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.domain.interactor.MovieListUseCase
import com.example.interviewtask.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val movieListUseCase: MovieListUseCase) : ViewModel() {

     val movieListLiveData : LiveData<PagedList<MovieModel>>
         get() {
            return movieListUseCase.getMovieList()
         }

}