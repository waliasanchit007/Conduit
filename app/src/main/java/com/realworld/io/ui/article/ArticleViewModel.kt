package com.realworld.io.ui.article

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realworld.api.models.objects.Article
import com.realworld.io.data.ArticleRepo
import kotlinx.coroutines.launch

class ArticleViewModel: ViewModel() {

    private val _articleToBeShown = MutableLiveData<Article>()
    val articleToShown :LiveData<Article> get() = _articleToBeShown



    fun getArticleFromSlug(articleSlug: String?){
        viewModelScope.launch {
            val articleResponse = articleSlug?.let { ArticleRepo.geArticleThroughSlug(it)
            }
            Log.i("Slug", "article called from slug")
            _articleToBeShown.value = articleResponse?.body()?.article
        }
    }

    fun passArticleSlug(articleSlug: String?) {
        getArticleFromSlug(articleSlug)
    }
}