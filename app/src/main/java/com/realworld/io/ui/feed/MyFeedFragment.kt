package com.realworld.io.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.realworld.io.R
import com.realworld.io.databinding.FragmentGlobalFeedBinding

class MyFeedFragment: Fragment() {

    lateinit var viewModel: MyFeedViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGlobalFeedBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_global_feed,container,false
        )

        viewModel = ViewModelProvider(this).get(MyFeedViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.fetchMyFeed()

        val adapter = ListViewAdapter(ArticleListener { articleSlug ->
            articleSlug?.let {
                Toast.makeText(context, "${articleSlug} is clicked", Toast.LENGTH_LONG).show()
                viewModel.onArticleClicked(articleSlug)

            }
        })
        binding.recyclerView.adapter = adapter

        viewModel.article.observe(viewLifecycleOwner, Observer {
            it.let {
                adapter.submitList(it)
            }

        })

        viewModel.navigateToArticleDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(
                    MyFeedFragmentDirections.actionNavMyFeedToArticleFragment(it)
                )
                viewModel.onArticleDetailNavigated()

            }

        })


        return binding.root
    }
}