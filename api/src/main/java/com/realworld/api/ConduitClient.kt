package com.realworld.api

import com.realworld.api.services.ConduitApi
import com.realworld.api.services.ConduitApiAuth
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClient {

    var authToken:String? = null

    private val authInterceptor = Interceptor{chain ->
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                .header("Authorization","Token $it")
                .build()

        }
        chain.proceed(req)

    }

    val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(2,TimeUnit.SECONDS)

    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("http://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())

    val api = retrofitBuilder
        .client(okHttpBuilder.build())
        .build()
        .create(ConduitApi::class.java)
    val authApi = retrofitBuilder
        .client(okHttpBuilder.addInterceptor(authInterceptor).build())
        .build()
        .create(ConduitApiAuth::class.java)

}