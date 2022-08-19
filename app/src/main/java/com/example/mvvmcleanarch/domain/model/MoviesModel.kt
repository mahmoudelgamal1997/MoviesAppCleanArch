package com.example.mvvmcleanarch.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


data class MoviesList (
    val results: List<Movie>,
    val totalResults: Int)

@Parcelize
data class Movie(
    val character: String?,
    val id: Int,
    val job: String?,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String,
    val voteAverage: Double
):Parcelable