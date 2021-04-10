package com.realworld.api.models.objects


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserLoginCreds(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)