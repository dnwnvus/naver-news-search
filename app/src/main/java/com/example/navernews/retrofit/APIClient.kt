package com.example.navernews.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object APIClient {
    private val httpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl.Base_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

