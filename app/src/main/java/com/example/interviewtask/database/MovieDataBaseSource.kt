package com.example.interviewtask.database

import com.example.interviewtask.data.model.MovieModel
import javax.inject.Inject

class MovieDataBaseSource @Inject constructor(val movieDataBase: MovieDataBase) {

    /* DATABASE interactor */

    suspend fun insertAllMovie(movieModelList: List<MovieModel>, page : Int){
        for(movieModel in movieModelList){
            movieModel.page = page
        }
        movieDataBase.formDao().insertAll(movieModelList)
    }

    suspend fun getMovieList(page: Int) : List<MovieModel>?{
        return movieDataBase.formDao().getAll(page)
    }
}