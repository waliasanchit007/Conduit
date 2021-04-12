package com.realworld.io.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.realworld.io.R
import com.realworld.io.databinding.FragmentAuthBinding

class AuthFragment: Fragment() {
    lateinit var binding: FragmentAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_auth,container,false)
        return binding.root
    }
}