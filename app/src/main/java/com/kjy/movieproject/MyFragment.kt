package com.kjy.movieproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kjy.movieproject.databinding.FragmentMyBinding


class MyFragment : Fragment() {

    lateinit var binding: FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}