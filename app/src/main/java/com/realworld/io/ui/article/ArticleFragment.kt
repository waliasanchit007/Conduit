package com.realworld.io.ui.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.realworld.io.R
import com.realworld.io.databinding.ArticleFragmentBinding

class ArticleFragment : Fragment() {

    lateinit var viewModel: ArticleViewModel
    lateinit var binding:ArticleFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,R.layout.article_fragment, container,false )
        viewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        val articleSlug = arguments?.let { ArticleFragmentArgs.fromBundle(it).articleSlug }
        Log.i("slug", "${articleSlug}")
        viewModel.passArticleSlug(articleSlug)



        return binding.root
    }

}