package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.data.model.MovieModel
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class NewMovieFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var nameEditText: TextInputEditText
    private lateinit var categoryEditText: TextInputEditText
    private lateinit var descriptionEditText: TextInputEditText
    private lateinit var qualificationEditText: TextInputEditText
    private lateinit var submitButton: Button

    private fun bind() {
        nameEditText = view?.findViewById(R.id.outlinedTextField) !!
        categoryEditText = view?.findViewById(R.id.outlinedTextField2) !!
        descriptionEditText = view?.findViewById(R.id.outlinedTextField3) !!
        qualificationEditText = view?.findViewById(R.id.outlinedTextField4) !!
        submitButton = view?.findViewById(R.id.button) !!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        submitButton.setOnClickListener(){
            addMovie()
        }

    }

    private fun addMovie(){
        val name = nameEditText.text.toString()
        val category = nameEditText.text.toString()
        val description = nameEditText.text.toString()
        val qualification = nameEditText.text.toString()

        val movie = MovieModel(name,category,description, qualification)
        movieViewModel.addMovies(movie)

        Log.d("NewMovieFragment", movieViewModel.getMovies().toString())
        findNavController().popBackStack()
    }

}