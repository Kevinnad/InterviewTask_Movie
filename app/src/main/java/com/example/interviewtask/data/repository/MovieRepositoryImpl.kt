package com.example.interviewtask.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.interviewtask.data.datastore.MovieDataSourceFactory
import com.example.interviewtask.data.datastore.MovieDataStore
import com.example.interviewtask.data.model.MovieModel
import com.example.interviewtask.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(val dataStore: MovieDataStore) : MovieRepository {

    private val MOVIE_PAGE_SIZE = 20
    private val PREFETCH_DISTANCE = 15


    override fun getMovieList(): LiveData<PagedList<MovieModel>> {

        val movieDataSourceFactory = MovieDataSourceFactory(dataStore)

        val config = PagedList.Config.Builder()
            .setPageSize(MOVIE_PAGE_SIZE)
            .setInitialLoadSizeHint(MOVIE_PAGE_SIZE)
            .setEnablePlaceholders(true)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .build()

        return LivePagedListBuilder(movieDataSourceFactory, config).build()
    }


}