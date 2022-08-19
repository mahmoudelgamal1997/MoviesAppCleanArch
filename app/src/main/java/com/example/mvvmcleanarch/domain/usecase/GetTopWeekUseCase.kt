package com.example.mvvmcleanarch.domain.usecase

import android.util.Log
import com.example.mvvmcleanarch.common.Resource
import com.example.mvvmcleanarch.data.mapper.toMovie
import com.example.mvvmcleanarch.domain.model.Movie
import com.example.mvvmcleanarch.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject


class GetTopWeekUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {

    operator fun invoke(): Flow<Resource<List<Movie>>> = flow{
    try {
        emit(Resource.Loading())
        val data = moviesRepository.getTopWeek()

        val domainData = if (!data.results.isNullOrEmpty())
            data.results.map { it.toMovie() } else emptyList()

        emit(Resource.Success(domainData))
    }catch (e:Exception){

        emit(Resource.Error(message = e.localizedMessage ?:"Unkown source"))
    }
    }
}