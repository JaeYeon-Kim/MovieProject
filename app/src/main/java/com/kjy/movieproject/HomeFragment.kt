package com.kjy.movieproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kjy.movieproject.databinding.FragmentHomeBinding


// 프래그먼트에서의 바인딩 사용
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        movieAdapter()
        return binding.root
    }


    private fun movieAdapter() {
        val movieList = mutableListOf<MovieData>()
        var adapter = CustomMovieAdapter()
        binding.movieRv.adapter = adapter

        movieList.apply {
            add(
                MovieData(
                    R.drawable.movie_1, "영화 1번"
                )
            )
            add(
                MovieData(
                    R.drawable.movie_2, "영화 2번"
                )
            )
            add(
                MovieData(
                    R.drawable.movie_3, "영화 3번"
                )
            )
            add(
                MovieData(
                    R.drawable.movie_4, "영화 4번"
                )
            )
        }

        adapter.movieList = movieList
        val layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)
        binding.movieRv.layoutManager = layoutManager
    }

}