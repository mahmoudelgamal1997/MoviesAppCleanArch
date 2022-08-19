package com.example.mvvmcleanarch.presentation.home

import TopWeekAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    val binding by viewBinding(FragmentHomeBinding::bind)
    val viewmodel: HomeViewModel by viewModels()
    val topWeekAdapter = TopWeekAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTopWeek()
        renderList()
        setClick()
    }

    fun renderList(){
        binding.rvTopWeek.apply {
            adapter = topWeekAdapter
            setHasFixedSize(true)
        }
    }

    fun getTopWeek(){
    lifecycle.coroutineScope.launch{
        viewmodel.topWeekState.collect{state->
            Log.e("gggggg",state.toString())

            if (state.isLoading){
                    binding.bar.isVisible= false
                    binding.rvTopWeek.isVisible = false
                }

            if (state.error.isNotBlank()) {
                binding.bar.isVisible = false
                binding.rvTopWeek.isVisible = false
            }

            state.data?.let {
                binding.bar.isVisible = false
                binding.rvTopWeek.isVisible = true
                topWeekAdapter.differ.submitList(it)
            }
        }
    }
    }


    fun setClick(){
        topWeekAdapter.onClickListener={
            val nav = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            findNavController().navigate(nav)
        }
    }
}