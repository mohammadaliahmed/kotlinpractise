package com.appslift.kotlinpractise

import com.appslift.calssifiedadskotlin.ApiService
import com.appslift.calssifiedadskotlin.Item

class DataRepository(private val apiService: ApiService) {
    suspend fun fetchData(): List<Item> {
        return apiService.getItems()
    }
}