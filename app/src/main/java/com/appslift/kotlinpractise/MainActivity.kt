package com.appslift.kotlinpractise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appslift.calssifiedadskotlin.ApiService
import com.appslift.calssifiedadskotlin.ItemAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DataViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ItemAdapter(emptyList())
        recyclerView.adapter = adapter
        fetchData()
    }

    private fun fetchData() {
        viewModel = ViewModelProvider(this,
            ViewModelFactory(ApiService.create()))[DataViewModel::class.java]
        viewModel.dataLiveData.observe(this) { data ->
            adapter.setData(data)
        }
        viewModel.fetchData()
    }


}