package com.example.interviewtask.domain.interactor

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.domain.repository.MovieRepository
import javax.inject.Inject

class MovieListUseCaseImp @Inject constructor(val movieRepository: MovieRepository) : MovieListUseCase {

/*Use case to load Movie List in the Main screen*/
    override fun getMovieList() : LiveData<PagedList<MovieModel>> {
        return movieRepository.getMovieList()
    }

}