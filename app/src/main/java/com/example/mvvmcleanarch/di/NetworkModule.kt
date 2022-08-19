package com.example.mvvmcleanarch.di

import com.example.mvvmcleanarch.data.remote.api.MovieApi
import com.example.mvvmcleanarch.data.repository.MoviesRepositoryImp
import com.example.mvvmcleanarch.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit):MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @Singleton
    fun provideNoteRepository( api: MovieApi): MoviesRepository {
        return MoviesRepositoryImp(api)
    }


}