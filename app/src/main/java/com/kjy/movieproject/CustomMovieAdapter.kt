package com.kjy.movieproject

import android.graphics.Movie
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kjy.movieproject.databinding.MovieListBinding

class CustomMovieAdapter: RecyclerView.Adapter<CustomHolder>() {

    var movieList = mutableListOf<MovieData>()

    // 뷰 홀더 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val binding = MovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomHolder(binding)

    }

    // 리사이클러뷰와 뷰 홀더 연결
    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        var movieData = movieList[position]
        holder.setHolder(movieData)

    }

    override fun getItemCount(): Int {
        Log.d("listSize", "${movieList.size}")
        return movieList.size

    }
}

class CustomHolder(val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root) {
    fun setHolder(movieData: MovieData) {
        Glide.with(itemView)
            .load(movieData.uri)
            .into(binding.movieImage)
        binding.movieTitle.text = movieData.title
    }

}