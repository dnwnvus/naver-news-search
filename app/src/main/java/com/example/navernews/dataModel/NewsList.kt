package com.example.navernews.dataModel

import com.google.gson.annotations.SerializedName

data class NewsList(
    @SerializedName("start")
    val start: Int,

    @SerializedName("display")
    val display: Int,

    @SerializedName("items")
    val items: ArrayList<NewsData>,
) {
    data class NewsData(
        @SerializedName("title")
        val title: String,

        @SerializedName("description")
        val description: String
    )
}


