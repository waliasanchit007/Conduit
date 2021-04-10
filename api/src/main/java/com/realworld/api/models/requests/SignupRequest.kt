package com.realworld.api.models.requests


import com.realworld.api.models.objects.UserCredsSignup
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignupRequest(
    @Json(name = "user")
    val user: UserCredsSignup
)