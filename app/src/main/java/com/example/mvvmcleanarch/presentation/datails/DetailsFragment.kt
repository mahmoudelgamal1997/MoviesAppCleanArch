package com.example.mvvmcleanarch.presentation.datails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.mvvmcleanarch.R
import com.example.mvvmcleanarch.common.Constants
import com.example.mvvmcleanarch.databinding.FragmentDetailsBinding
import com.example.mvvmcleanarch.domain.model.Movie

class DetailsFragment : Fragment(R.layout.fragment_details) {

    val binding:FragmentDetailsBinding by viewBinding()
    val args:DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI(args.movieId)
    }
    fun bindUI(movie:Movie){
        binding.apply {
            textSearch.text= movie.title
            textSearchDate.text =movie.releaseDate
            textSummary.text = movie.overview
            Glide.with(root).load(Constants.IMAGE_URL +movie.posterPath)
                .into(imageView)
        }
    }}