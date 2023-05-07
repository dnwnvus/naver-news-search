package com.example.navernews

import android.annotation.SuppressLint
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.dataModel.NewsList
import com.example.navernews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: SearchResultAdapter

    private val searchResult = findViewById<RecyclerView>(R.id.recycler)

    private var newsDatas = listOf<NewsList.NewsData>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        adapter = SearchResultAdapter()

        binding.etButton.setOnClickListener {
            Toast.makeText(applicationContext, binding.etSearch.text.toString(), Toast.LENGTH_SHORT).show()
            viewModel.searchNews(binding.etSearch.text.toString())
            binding.etSearch.setText("")
            adapter.setDatas(newsDatas)
            adapter.notifyDataSetChanged()
        }

        binding.recycler.apply {
            searchResult.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
