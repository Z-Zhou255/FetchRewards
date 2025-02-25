package com.app.rewards.network

import com.app.rewards.model.Item
import retrofit2.http.GET

interface ListApiService {
    @GET("hiring.json")
    suspend fun fetchListRewards(): List<Item>
}