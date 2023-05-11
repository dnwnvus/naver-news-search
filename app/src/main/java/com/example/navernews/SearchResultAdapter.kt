package com.example.navernews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.dataModel.NewsList
import com.example.navernews.databinding.NewsSearchResultBinding

class SearchResultAdapter: RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    private var newsDatas = ArrayList<NewsList.NewsData>()

    inner class ViewHolder(private val binding: NewsSearchResultBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(i: Int){
            binding.title.text = newsDatas[i].title
            binding.description.text = newsDatas[i].description
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = NewsSearchResultBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(position)
    }

    override fun getItemCount() = newsDatas.size

    fun setDatas(datas: ArrayList<NewsList.NewsData>) {
        newsDatas = datas
    }
}