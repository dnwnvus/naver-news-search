package com.example.navernews

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navernews.dataModel.NewsList
import com.example.navernews.repository.Repository
import com.example.navernews.retrofit.BaseUrl
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainViewModel: ViewModel() {
    private val newsDatas = MutableLiveData<NewsList>()

    val getNewsDatas: LiveData<NewsList> get() = newsDatas

    private val repo = Repository()

    fun searchNews(text: String) {
        repo.getSearchNewsList(text, 1, 10).subscribe(object: SingleObserver<NewsList> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onSuccess(newsList: NewsList) {
                Log.d("TESTLOG", "SUCCESS")
                newsDatas.postValue(newsList)
            }

            override fun onError(t: Throwable) {
                Log.d("TESTLOG", "FAILURE")
            }
        })
    }
}
