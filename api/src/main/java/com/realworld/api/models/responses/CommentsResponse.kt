package com.realworld.api.models.responses


import com.realworld.api.models.objects.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentsResponse(
    @Json(name = "comments")
    val comments: List<Comment>
)