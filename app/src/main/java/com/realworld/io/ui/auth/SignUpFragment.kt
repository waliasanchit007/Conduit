package com.realworld.io.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.realworld.io.R
import com.realworld.io.databinding.FragmentLoginBinding
import com.realworld.io.databinding.FragmentSignUpBinding

class SignUpFragment:Fragment() {

    val viewModel :AuthViewModel by activityViewModels()
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up,container, false)

        binding.signupBtn.setOnClickListener {
            viewModel.onSignUpClicked(
                binding.signupUsernameEdt.text.toString(),
                binding.signupEmailEdt.text.toString(),
                binding.signupPasswordEdt.text.toString()
            )

        }

        return binding.root
    }
}