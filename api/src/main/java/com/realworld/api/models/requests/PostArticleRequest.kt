package com.realworld.api.models.requests


import com.realworld.api.models.objects.UserArticlePost
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostArticleRequest(
    @Json(name = "article")
    val article: UserArticlePost
)