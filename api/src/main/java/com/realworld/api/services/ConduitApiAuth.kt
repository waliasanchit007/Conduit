package com.realworld.api.services

import com.realworld.api.models.objects.Profile
import com.realworld.api.models.requests.UserUpdateRequest
import com.realworld.api.models.objects.User
import com.realworld.api.models.requests.PostArticleRequest
import com.realworld.api.models.requests.UserCommentRequest
import com.realworld.api.models.responses.*
import retrofit2.http.*
import javax.annotation.PostConstruct
import javax.xml.ws.Response

interface ConduitApiAuth {

    @GET("user")
    suspend fun getCurrentUser():Response<UserResponse>

    @PUT("user")
    suspend fun updateUsers(
            @Body userUpdateRequest: UserUpdateRequest
    ):Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
            @Path("username") username : String
    ): Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun followProfile(
            @Path("username") username: String
    ): Response<ProfileResponse>

    @DELETE("profiles/{username}/follow")
    suspend fun unfollowProfile(
            @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles(): retrofit2.Response<ArticlesResponse>

    @POST("articles")
    suspend fun createArticle(
            @Body postArticleRequest: PostArticleRequest
    ):Response<ArticleResponse>

    @PUT("articles/{slug}")
    suspend fun updateArticle(
            @Path("slug") slug :String,
            @Body postArticleRequest: PostArticleRequest
    ):Response<ArticleResponse>

    @DELETE("articles/{slug}")
    suspend fun deleteArticles(
            @Path("slug") slug: String
    )

    @POST("articles/{slug}/comments")
    suspend fun addCommentToArticle(
            @Path("slug") slug: String,
            @Body commentRequest: UserCommentRequest
    ):Response<CommentResponse>

    @GET("articles/{slug}/comments")
    suspend fun getAllCommentsOfArticle(
            @Path("slug") slug:String
    ):Response<CommentsResponse>

    @DELETE("articles/{slug}/comments/{id}")
    suspend fun deleteComments(
            @Path("slug") slug: String, @Path("id") id:Int
    )

    @POST("articles/{slug}/favorite")
    suspend fun favouriteArticle(
            @Path("slug") slug: String
    ):Response<ArticleResponse>

    @DELETE("articles/{slug}/favorite")
    suspend fun unfavoriteArticle(
            @Path("slug") slug: String
    ):Response<ArticleResponse>

}