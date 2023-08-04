package ru.blackmirrror.moviesapp.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.blackmirrror.moviesapp.R
import ru.blackmirrror.moviesapp.data.api.ApiFactory
import ru.blackmirrror.moviesapp.data.api.ApiService
import ru.blackmirrror.moviesapp.data.repository.MoviesRepositoryImpl
import ru.blackmirrror.moviesapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by lazy { SearchViewModel(MoviesRepositoryImpl(ApiFactory.create())) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        initMovies()

        return binding.root
    }

    private fun initMovies() {
        val adapter = SearchMovieAdapter()
        lifecycleScope.launch {
            viewModel.movies.flowWithLifecycle(lifecycle).collect { movies ->
                adapter.setMovies(movies)
            }
        }
        binding.rvItems.adapter = adapter
    }
}