package com.realworld.api

import com.realworld.api.models.objects.UserCredsSignup
import com.realworld.api.models.requests.SignupRequest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.*
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {
    private val conduitClient = ConduitClient()


    @Test
    fun `GET Articles`(){
        runBlocking{
            val articles = withContext(Dispatchers.IO){conduitClient.api.getArticles().body()?.articles}
            if (articles != null) {
                println("${articles[0].author }")
            }else println("else")

            assertNotNull(articles)

        }
    }

    @Test
    fun `GET Articles by author`(){
        runBlocking {
            val articles = withContext(Dispatchers.IO){
                conduitClient.api.getArticles(author = "444").body()?.articles
            }

            articles?.map { println(it) }

        }
    }

    @Test
    fun `GET Articles by TAG`(){
        runBlocking {
            val articles = withContext(Dispatchers.IO){
                conduitClient.api.getArticles(tag = "Gandhi").body()?.articles
            }

            articles?.map { println(it) }

        }
    }

    @Test
    fun `Send signup request`(){

        val userCreds = UserCredsSignup(
                "test1234qwert${Random.nextInt(999,99999)}@test.com",
        "testpass${Random.nextInt(999,99999)}",
                "testuser${Random.nextInt(99, 9999)}"
        )
        runBlocking {
            val user = withContext(Dispatchers.IO){
                conduitClient.api.signupUser(
                        SignupRequest(userCreds)
                )
            }
            println(user.body()?.user)
            assertEquals(userCreds.username, user.body()?.user?.username)
        }
    }


}