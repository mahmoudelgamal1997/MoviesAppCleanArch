package com.example.mvvmcleanarch.presentation.home

import com.example.mvvmcleanarch.domain.model.Movie

data class MovieState(
    val isLoading:Boolean= false,
    val error:String="",
    val data:List<Movie>?= null
)
