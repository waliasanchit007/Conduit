package com.realworld.io.data

import com.realworld.api.ConduitClient
import com.realworld.api.models.objects.UserCredsSignup
import com.realworld.api.models.objects.UserLoginCreds
import com.realworld.api.models.requests.LoginRequest
import com.realworld.api.models.requests.SignupRequest
import com.realworld.api.models.responses.UserResponse
import retrofit2.Response

object UserRepo {

    val api = ConduitClient.api
    val authApi = ConduitClient.authApi

    suspend fun login(email:String, password:String): Response<UserResponse> {

        val response= api.loginUser(LoginRequest(UserLoginCreds(email,password)))

        //TODO save authToken in savedPreferences
        ConduitClient.authToken = response.body()?.user?.token

        return response
    }

    suspend fun signUp(username:String,email:String, password:String): Response<UserResponse> {

        val response = api.signupUser(SignupRequest(UserCredsSignup(email,password, username)))

        //TODO save authToken in savedPreferences
        ConduitClient.authToken = response.body()?.user?.token
        return response
    }

}