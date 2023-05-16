package com.example.navernews

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.databinding.ActivityMainBinding
import com.example.navernews.sharedPreference.NaverNews

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = SearchResultAdapter()
        val searchResult = findViewById<RecyclerView>(R.id.recycler)

        viewModel.getNewsDatas.observe(this, {
            if (it != null) {
                Log.d("TestLog", it.toString())
                adapter.setDatas(it.items)
                adapter.notifyDataSetChanged()
            }
        })

        binding.etButton.setOnClickListener {
            val searchText = binding.etSearch.text.toString()

            // data/data/NaverNews/prefs
            NaverNews.prefs.setString("searchedText", searchText)

            viewModel.searchNews(searchText)

            Toast.makeText(this, searchText, Toast.LENGTH_SHORT).show()
        }

        binding.recycler.apply {
            searchResult.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
