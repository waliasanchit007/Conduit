package com.realworld.api.models.requests


import com.realworld.api.models.objects.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserCommentRequest(
    @Json(name = "comment")
    val comment: Comment
)