package com.kjy.movieproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kjy.movieproject.databinding.FragmentMobileBinding

class MobileFragment : Fragment() {

    lateinit var binding: FragmentMobileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMobileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}