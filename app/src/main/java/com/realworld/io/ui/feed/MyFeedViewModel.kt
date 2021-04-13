package com.realworld.io.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realworld.api.models.objects.Article
import com.realworld.io.data.ArticleRepo
import kotlinx.coroutines.launch

class MyFeedViewModel  : ViewModel() {


    private val _article= MutableLiveData<List<Article>>()
    val article: LiveData<List<Article>> get() = _article


    fun fetchMyFeed(){
        viewModelScope.launch {
            _article.value = ArticleRepo.getMyFeed().body()?.articles

        }
    }

    private val _navigateToArticleDetail = MutableLiveData<String?>()
    val navigateToArticleDetail : LiveData<String?> get() = _navigateToArticleDetail

    fun onArticleClicked(slug:String){
        _navigateToArticleDetail.value = slug
    }

    fun onArticleDetailNavigated(){
        _navigateToArticleDetail.value = null
    }
}