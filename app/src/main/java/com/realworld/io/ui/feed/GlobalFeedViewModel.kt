package com.realworld.io.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realworld.api.models.objects.Article
import com.realworld.io.data.ArticleRepo
import kotlinx.coroutines.launch

class GlobalFeedViewModel : ViewModel() {

    init {
        fetchGlobalFeed()
    }

    private val _article= MutableLiveData<List<Article>>()
    val article:LiveData<List<Article>> get() = _article

    fun fetchGlobalFeed(){
        viewModelScope.launch {
           ArticleRepo.getGlobalFeed().body()?.let {
               _article.value = it.articles

               Log.i("article fetch", "${it.articlesCount} articles fetched")
           }
        }
    }
}