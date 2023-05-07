package com.example.navernews.retrofit

import com.example.navernews.dataModel.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverAPI {
    @GET("v1/search/news.json")
    fun getSearchNews(
        @Header("X-Naver-Client-Id") clientId: String ,
        @Header("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int
    ): Call<NewsList>
}