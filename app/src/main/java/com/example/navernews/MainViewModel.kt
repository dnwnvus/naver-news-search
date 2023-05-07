package com.example.navernews

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.navernews.dataModel.NewsList
import com.example.navernews.retrofit.APIClient
import com.example.navernews.retrofit.BaseUrl
import com.example.navernews.retrofit.NaverAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {
    private var searchText = ""

    private lateinit var adapter: SearchResultAdapter

    var newsDatas = listOf<NewsList.NewsData>()

    private val api = APIClient.retrofit.create(NaverAPI::class.java)

    private val callGetSearchNews = api.getSearchNews(BaseUrl.Client_ID, BaseUrl.Client_Secret, "안녕", 1, 10)
    fun searchNews(text: String) {
        this.searchText = text

        callGetSearchNews.enqueue(object: Callback<NewsList> {
            override fun onResponse(
                call: Call<NewsList>,
                response: Response<NewsList>
            ) {
                Log.d("TESTLOG", "SUCCESS")
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Log.d("TESTLOG", response.body()!!.items[0].title)
                        newsDatas = response.body()!!.items
                        adapter.setDatas(newsDatas)
                    }
                }
            }

            override fun onFailure(call: Call<NewsList>, t: Throwable) {
                Log.d("TESTLOG", "FAILURE")
            }
        })
    }

}