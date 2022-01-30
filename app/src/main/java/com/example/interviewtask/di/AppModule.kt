package com.example.interviewtask.di

import android.content.Context
import com.example.interviewtask.database.DataBaseProvider
import com.example.interviewtask.database.MovieDataBase
import com.example.interviewtask.database.MovieDataBaseSource
import com.example.interviewtask.data.datastore.MovieDataStore
import com.example.interviewtask.data.datastore.MovieDataStoreImpl
import com.example.interviewtask.network.HttpClientBuilderFactory
import com.example.interviewtask.network.Services
import com.example.interviewtask.domain.repository.MovieRepository
import com.example.interviewtask.data.repository.MovieRepositoryImpl
import com.example.interviewtask.domain.interactor.MovieListUseCase
import com.example.interviewtask.domain.interactor.MovieListUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesService(httpClient: HttpClientBuilderFactory): Services = Services.createService(httpClient)

    @Provides
    @Singleton
    fun provideHttpBuilderFactory() : HttpClientBuilderFactory = HttpClientBuilderFactory()

    @Provides
    fun provideMovieDataBaseRoom(@ApplicationContext context: Context) : MovieDataBase = DataBaseProvider(context).createDB()

    @Provides
    fun provideMovieDataBaseSource(movieDataBase: MovieDataBase) : MovieDataBaseSource = MovieDataBaseSource(movieDataBase)

    @Provides
    fun provideMovieDataStore(services: Services, movieDataBase: MovieDataBaseSource) : MovieDataStore = MovieDataStoreImpl(services,movieDataBase)

    @Provides
    fun provideMovieRepository(movieDataStore: MovieDataStore) : MovieRepository = MovieRepositoryImpl(movieDataStore)

    @Provides
    fun provideMovieListUseCase(movieRepository: MovieRepository) : MovieListUseCase = MovieListUseCaseImp(movieRepository)
}