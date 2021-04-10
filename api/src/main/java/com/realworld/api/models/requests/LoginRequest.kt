package com.realworld.api.models.requests


import com.realworld.api.models.objects.UserLoginCreds
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: UserLoginCreds
)