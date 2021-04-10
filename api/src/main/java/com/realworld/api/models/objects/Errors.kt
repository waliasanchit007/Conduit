package com.realworld.api.models.objects


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Errors(
    @Json(name = "body")
    val body: List<String>
)