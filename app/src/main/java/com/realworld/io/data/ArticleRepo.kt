package com.realworld.io.data

import com.realworld.api.ConduitClient

object ArticleRepo {
    val api = ConduitClient.api
    val authApi = ConduitClient.authApi

    suspend fun getGlobalFeed() = api.getArticles()

    suspend fun geArticleThroughSlug(slug:String) = api.getArticleBySlug(slug)

    suspend fun getMyFeed() = authApi.getFeedArticles()
}