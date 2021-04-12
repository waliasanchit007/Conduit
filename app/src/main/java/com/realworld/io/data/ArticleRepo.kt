package com.realworld.io.data

import com.realworld.api.ConduitClient

object ArticleRepo {
    val api = ConduitClient().api

    suspend fun getGlobalFeed() = api.getArticles()

    suspend fun geArticleThroughSlug(slug:String) = api.getArticleBySlug(slug)
}