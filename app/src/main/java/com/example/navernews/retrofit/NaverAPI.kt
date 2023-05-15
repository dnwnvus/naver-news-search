package com.example.navernews.retrofit

import com.example.navernews.dataModel.NewsList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverAPI {
    @Headers("X-Naver-Client-Id: " + BaseUrl.Client_ID, "X-Naver-Client-Secret: " + BaseUrl.Client_Secret)
    @GET("/v1/search/news.json")
    fun getSearchNews(
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int
    ): Single<NewsList>
}