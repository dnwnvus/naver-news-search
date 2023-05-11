package com.example.navernews

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navernews.dataModel.NewsList
import com.example.navernews.repository.Repository
import com.example.navernews.retrofit.BaseUrl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainViewModel: ViewModel() {
    private val newsDatas = MutableLiveData<NewsList>()

    fun getNewsDatas(): MutableLiveData<NewsList> {
        return newsDatas
    }

    private val repo = Repository()

    fun searchNews(text: String) {
        repo.getSearchNewsList(BaseUrl.Client_ID, BaseUrl.Client_Secret, text, 1, 10).subscribe(object: SingleObserver<NewsList> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onSuccess(newsList: NewsList) {
                Log.d("TESTLOG", "SUCCESS")
                newsDatas.value = newsList
            }

            override fun onError(t: Throwable) {
                Log.d("TESTLOG", "FAILURE")
            }
        })
    }
}
