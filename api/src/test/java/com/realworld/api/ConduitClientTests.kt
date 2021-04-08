package com.realworld.api

import com.realworld.api.models.Article
import com.realworld.api.models.ArticlesResponse
import kotlinx.coroutines.*
import org.junit.Test
import sun.rmi.runtime.Log
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.math.log

class ConduitClientTests {
    private val conduitClient = ConduitClient()

   suspend fun networkCall() : List<Article>?{
       return withContext(Dispatchers.IO){
           conduitClient.api.getArticles().body()?.articles
       }
   }

    @Test
    fun `GET Articles`(){
        runBlocking{
            val articles = networkCall()
            if (articles != null) {
                println("${articles[0].author }")
            }else println("else")

        }
    }
}