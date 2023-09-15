package com.appslift.kotlinpractise


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.appslift.calssifiedadskotlin.ApiService

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataViewModel::class.java)) {
            return DataViewModel(DataRepository(apiService)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
