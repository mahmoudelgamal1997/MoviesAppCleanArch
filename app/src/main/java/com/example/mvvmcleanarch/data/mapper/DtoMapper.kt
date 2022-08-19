package com.example.mvvmcleanarch.data.mapper

import com.example.mvvmcleanarch.data.remote.dto.MovieDTO
import com.example.mvvmcleanarch.data.remote.dto.MoviesListDTO
import com.example.mvvmcleanarch.domain.model.Movie
import com.example.mvvmcleanarch.domain.model.MoviesList


internal fun MoviesListDTO.toMovieList():MoviesList = MoviesList(results.map { it.toMovie() },totalResults)

fun MovieDTO.toMovie():Movie {
    return Movie(character,id, job, overview, posterPath, releaseDate, title, voteAverage)
}