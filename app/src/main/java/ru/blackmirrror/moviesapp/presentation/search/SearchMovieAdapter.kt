package ru.blackmirrror.moviesapp.presentation.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.blackmirrror.moviesapp.R
import ru.blackmirrror.moviesapp.domain.models.MovieResponse

class SearchMovieAdapter: RecyclerView.Adapter<SearchMovieAdapter.SearchMovieViewHolder>() {

    private var movies = listOf<MovieResponse>()

    fun setMovies(movies: List<MovieResponse>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return SearchMovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        holder.onBind(movies[position])
    }

    class SearchMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image = itemView.findViewById<ImageView>(R.id.iv_item_image)
        val title = itemView.findViewById<TextView>(R.id.tv_item_title)
        val description = itemView.findViewById<TextView>(R.id.tv_item_description)
        val genre = itemView.findViewById<TextView>(R.id.tv_item_genre_year)

        fun onBind(movie: MovieResponse) {
            title.text = movie.nameRu
            description.text = movie.countries[0].toString()
            genre.text = "${movie.genres[0]} (${movie.year})"
        }
    }
}