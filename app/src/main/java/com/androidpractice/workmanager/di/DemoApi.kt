package com.androidpractice.workmanager.di

import retrofit2.Response
import retrofit2.http.GET

interface DemoApi {
    @GET("posts/1")
    suspend fun getPost(): Response<Post>
}