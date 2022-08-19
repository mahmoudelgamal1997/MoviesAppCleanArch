package com.example.mvvmcleanarch.data.remote.api

import com.example.mvvmcleanarch.data.remote.dto.MoviesListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular?api_key=271236134afbbdcd24c3caaaab027824&language=ru-RU")
    suspend fun getMoviesList(
        @Query("page") page:Int
    ):MoviesListDTO

    @GET("movie/top_rated?api_key=271236134afbbdcd24c3caaaab027824&language=ru-Ru")
    suspend fun getTopRating(
        @Query("page") page: Int
    ): MoviesListDTO


    @GET("trending/movie/week?api_key=271236134afbbdcd24c3caaaab027824&language=ru-Ru")
    suspend fun getWeek(): MoviesListDTO

    @GET("search/movie?api_key=271236134afbbdcd24c3caaaab027824&language=ru-RU")
    suspend fun searchMovie(
        @Query("query") query: String
    ): MoviesListDTO

}