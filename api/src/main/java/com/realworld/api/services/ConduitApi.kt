package com.realworld.api.services

import com.realworld.api.models.requests.LoginRequest
import com.realworld.api.models.responses.ArticlesResponse
import com.realworld.api.models.responses.UserResponse
import com.realworld.api.models.requests.SignupRequest
import com.realworld.api.models.responses.ArticleResponse
import com.realworld.api.models.responses.TagsResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {

    @GET("articles")
    suspend fun getArticles(
            @Query("author") author :String? = null,
            @Query("favourited") favourited:String? = null,
            @Query("tag") tag:String? = null,
            @Query("limit") limit:Int? = 20,
            @Query("offset") offset:Int? = 0
    ) : Response<ArticlesResponse>

    @POST("users")
    suspend fun signupUser(
            @Body signupRequest: SignupRequest
    ): Response<UserResponse>


    @POST("login")
    suspend fun loginUser(
            @Body loginRequest: LoginRequest
    ):Response<UserResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
            @Path("slug") slug:String
    ):Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags(): Response<TagsResponse>
}