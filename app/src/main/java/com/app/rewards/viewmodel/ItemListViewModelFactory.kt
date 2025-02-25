package com.app.rewards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.rewards.network.ListRepository

class ItemListViewModelFactory(
    private val repository: ListRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ItemListViewModel::class.java)) {
            return ItemListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}