package com.example.navernews

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navernews.databinding.ActivityMainBinding

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
            Toast.makeText(applicationContext, binding.etSearch.text.toString(), Toast.LENGTH_SHORT).show()
            viewModel.searchNews(binding.etSearch.text.toString())
            binding.etSearch.setText("")
        }

        binding.recycler.apply {
            searchResult.adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}
