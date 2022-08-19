package com.example.mvvmcleanarch.domain.repository

import com.example.mvvmcleanarch.data.remote.dto.MoviesListDTO
import com.example.mvvmcleanarch.domain.model.Movie

interface MoviesRepository {
    suspend fun getTopWeek(): MoviesListDTO

    suspend fun getSearch(name: String): MoviesListDTO

}