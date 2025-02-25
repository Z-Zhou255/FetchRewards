package com.app.rewards.network

import com.app.rewards.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ListRepository(
    private val apiService: ListApiService
) {
    fun getListRewardItems(): Flow<List<Item>> = flow {
        try {
            val list = apiService.fetchListRewards()
            //filter list that has empty name, sorting first by listId followed by name and emit data
            emit(list.filter { !it.name.isNullOrBlank() }
                .sortedWith(compareBy( {it.listId}, {it.name})))
        } catch (exception: Exception) {
            //emit empty list when there is an exception
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}