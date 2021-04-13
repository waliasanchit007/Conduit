package com.realworld.io.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.realworld.api.ConduitClient
import com.realworld.io.R
import com.realworld.io.databinding.FragmentLoginBinding

class LoginFragment:Fragment() {

    private lateinit var binding:FragmentLoginBinding
    val viewModel :AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container, false)
         binding.loginBtn.setOnClickListener {
             viewModel.onLoginClicked(
                 binding.loginEmailEdt.text.toString(),
                 binding.loginPasswordEdt.text.toString())
         }



        return binding.root
    }
}