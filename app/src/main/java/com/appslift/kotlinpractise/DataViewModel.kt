package com.appslift.kotlinpractise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appslift.calssifiedadskotlin.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataViewModel(private val repository: DataRepository) : ViewModel() {

    private val ddataLiveData = MutableLiveData<List<Item>>()
    val dataLiveData: LiveData<List<Item>> = ddataLiveData
    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = repository.fetchData()
                withContext(Dispatchers.Main) {
                    ddataLiveData.value = result
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}