package com.example.navernews.repository

import com.example.navernews.dataModel.NewsList
import com.example.navernews.retrofit.APIClient
import com.example.navernews.retrofit.NaverAPI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {
    private val api = APIClient.retrofit.create(NaverAPI::class.java)

    fun getSearchNewsList(
        ClientId: String,
        ClientSecret: String,
        text: String,
        start: Int,
        display: Int): Single<NewsList> = api
            .getSearchNews(ClientId, ClientSecret, text, start, display)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}