package com.github.ebnhzr.movietrackr.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.ebnhzr.movietrackr.R
import com.github.ebnhzr.movietrackr.database.MovieDatabase
import com.github.ebnhzr.movietrackr.databinding.FragmentMovieDetailsBinding

/**
 * A simple [Fragment] subclass.
 */
class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_movie_details, container, false)

        val application = requireNotNull(this.activity).application
        val arguments = MovieDetailsFragmentArgs.fromBundle(arguments!!)
        val dataSource = MovieDatabase.getInstance(application).movieDatabaseDao

        val viewModelFactory = MovieDetailsViewModelFactory(arguments.movieKey, dataSource)
        val movieDetailsViewModel = ViewModelProviders.of(this, viewModelFactory)
                                        .get(MovieDetailsViewModel::class.java)

        binding.movieDetailsViewModel = movieDetailsViewModel

        movieDetailsViewModel.navigateToMovieTracker.observe(this, Observer {status ->
            when (status) {
                "clear" -> {
                    this.findNavController().navigate(MovieDetailsFragmentDirections
                        .actionMovieDetailsFragmentToMovieTrackerFragment())
                    movieDetailsViewModel.doneNavigating()
                }
                "emptyMovieName" -> Toast.makeText(this.context, "TITLE NEEDED.", Toast.LENGTH_SHORT).show()
                "emptyRating" -> Toast.makeText(this.context, "PLEASE RATE THE MOVIE FIRST.", Toast.LENGTH_SHORT).show()
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }


}