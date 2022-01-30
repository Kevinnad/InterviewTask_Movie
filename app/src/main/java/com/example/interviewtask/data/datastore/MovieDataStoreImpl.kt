package com.example.interviewtask.data.datastore

import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.data.model.MovieResult
import com.example.interviewtask.database.MovieDataBaseSource
import com.example.interviewtask.network.ResultWrapper
import com.example.interviewtask.network.Services
import com.example.interviewtask.network.handleRequest
import com.example.interviewtask.utils.Constant.MOVIE_API_KEY
import javax.inject.Inject

class MovieDataStoreImpl @Inject constructor(
    val services: Services,
    val movieDataBaseSource: MovieDataBaseSource
) : MovieDataStore {

    override suspend fun getMovieList(pageNumber: Int): ResultWrapper<List<MovieModel>> {
        return updateMovieInDB(pageNumber)
    }

    suspend fun fetchForms(formsResult: ResultWrapper<MovieResult>, pageNumber: Int): ResultWrapper<List<MovieModel>> {

        when (formsResult) {
            is ResultWrapper.Success -> {
                return insertForms(formsResult.value.results,pageNumber)
            }
            is ResultWrapper.NetworkError -> {
                return formsResult
            }
            is ResultWrapper.GenericError -> {
                return formsResult
            }
            else ->
                throw Exception()
        }
    }

    private suspend fun insertForms(movieList: List<MovieModel>, pageNumber: Int): ResultWrapper<List<MovieModel>> {
        movieDataBaseSource.insertAllMovie(movieList,pageNumber)
        return updateMovieInDB(pageNumber)
    }

    suspend private fun updateMovieInDB(pageNumber: Int): ResultWrapper<List<MovieModel>> {

        val movieList = movieDataBaseSource.getMovieList(pageNumber)

        if (movieList != null && movieList.size > 0) {
            return handleRequest { movieList }
        } else {
            return fetchForms(handleRequest { services.getMovieListApi(MOVIE_API_KEY,pageNumber) },pageNumber)
        }
    }

}