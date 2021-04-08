package com.realworld.api.services

import com.realworld.api.models.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ConduitApi {

    @GET("articles")
    suspend fun getArticles() : Response<ArticlesResponse>
}