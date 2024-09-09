package com.example.capstoneapp.screens.search

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneapp.data.Resource
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel@Inject constructor(private val repository: BookRepository): ViewModel() {

     var list: List<Item> by mutableStateOf(listOf())
     var categoryList: List<Item> by mutableStateOf(listOf())
    var isLoading: Boolean by mutableStateOf(false)
    var isLoadingByCategory: Boolean by mutableStateOf(false)
    init {
        loadBooks()
    }

    private fun loadBooks(){
        searchByCategoryBooks("Trending")
    }

    fun searchByCategoryBooks(query: String){
        viewModelScope.launch {
            isLoadingByCategory = true
            if(query.isEmpty()){
                return@launch
            }
            try {
                when(val response = repository.getBooks(query)) {
                    is Resource.Success -> {
                        categoryList = response.data!!
                        isLoadingByCategory = false

                    }
                    is Resource.Error -> {
                        isLoadingByCategory = false

                    }
                    is Resource.Loading -> {
                        isLoadingByCategory = false
                    }
                }
            }catch (exception: Exception){
                isLoadingByCategory = false
                Log.e("ERROR", "Searching books error: ${exception.message.toString()}")
            }
        }
    }

     fun searchBooks(query: String){
        viewModelScope.launch {
            isLoading = true
            if(query.isEmpty()){
                return@launch
            }
            try {
                when(val response = repository.getBooks(query)) {
                    is Resource.Success -> {
                        list = response.data!!
                        isLoading = false
                    }
                    is Resource.Error -> {
                        isLoading = false

                    }
                    is Resource.Loading -> {
                        isLoading = false

                    }
                }
            }catch (exception: Exception){
                isLoading = false
                Log.e("ERROR", "Searching books error: ${exception.message.toString()}")
            }
        }
    }

}