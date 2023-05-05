package com.example.laboratorio_05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.laboratorio_05.R
import com.example.laboratorio_05.databinding.FragmentBillboardBinding
import com.example.laboratorio_05.databinding.FragmentMovieBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {
    private lateinit var buttonFirstFragment: FloatingActionButton
    private lateinit var cardViewMovies: CardView

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentBillboardBinding

   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentBillboardBinding.inflate(inflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

        cardViewMovies.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
        }

        setViewModel()
    }

    private fun bind() {
        buttonFirstFragment = view?.findViewById(R.id.floating_action_button) as FloatingActionButton
        cardViewMovies = view?.findViewById(R.id.cardView) as CardView
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }


}