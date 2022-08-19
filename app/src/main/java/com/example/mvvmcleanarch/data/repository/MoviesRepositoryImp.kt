package com.example.mvvmcleanarch.data.repository

import com.example.mvvmcleanarch.data.remote.api.MovieApi
import com.example.mvvmcleanarch.data.remote.dto.MoviesListDTO
import com.example.mvvmcleanarch.domain.model.Movie
import com.example.mvvmcleanarch.domain.repository.MoviesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImp @Inject constructor(
val api: MovieApi
):MoviesRepository {
    override suspend fun getTopWeek(): MoviesListDTO {
     return  api.getWeek()
    }
    override suspend fun getSearch(name: String): MoviesListDTO = api.searchMovie(name)
}