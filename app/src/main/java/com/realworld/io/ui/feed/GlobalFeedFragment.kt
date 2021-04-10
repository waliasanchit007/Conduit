package com.realworld.io.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.realworld.io.R
import com.realworld.io.databinding.FragmentGlobalFeedBinding

class GlobalFeedFragment: Fragment() {

    lateinit var viewModel: GlobalFeedViewModel
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGlobalFeedBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_global_feed,container,false
        )

        viewModel = ViewModelProvider(this).get(GlobalFeedViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val adapter = ListViewAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.article.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.articles = it
            }

        })

        return binding.root
    }
}