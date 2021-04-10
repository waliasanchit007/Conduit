package com.realworld.api.models.requests


import com.realworld.api.models.objects.UserUpdateCreds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val user: UserUpdateCreds
)