package com.example.mvvmcleanarch.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcleanarch.common.Resource
import com.example.mvvmcleanarch.domain.usecase.GetTopWeekUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class HomeViewModel @Inject constructor(
    private val useCase: GetTopWeekUseCase
) :ViewModel() {

private val _topWeekStateFlow = MutableStateFlow(MovieState())
val topWeekState :StateFlow<MovieState> = _topWeekStateFlow

    init {
        getWeek()
    }

    fun getWeek(){
        viewModelScope.launch {
            val data = useCase.invoke().collect{
                when(it){
                 is  Resource.Loading->{
                     _topWeekStateFlow.value = MovieState(isLoading = true)
                 }
                 is Resource.Success->{
                     _topWeekStateFlow.value = MovieState(data= it.data)
                 }
                  is Resource.Error ->{
                      _topWeekStateFlow.value = MovieState(error = it.message.toString())
                  }
                }
            }
        }
    }
}