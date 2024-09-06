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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel@Inject constructor(private val repository: BookRepository): ViewModel() {

     var list: List<Item> by mutableStateOf(listOf())
    init {
        loadBooks()
    }

    private fun loadBooks(){
        searchBooks("Romance")
    }
     fun searchBooks(query: String){
        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()){
                return@launch
            }
            try {
                when(val response = repository.getBooks(query)) {
                    is Resource.Success -> {
                        list = response.data!!
                    }
                    is Resource.Error -> {
                       Log.e("ERROR", "Searching books error: Failed to get books")
                    }
                    is Resource.Loading -> {
                        Log.e("LOADING", "Loading books")
                    }
                }
            }catch (exception: Exception){
                Log.e("ERROR", "Searching books error: ${exception.message.toString()}")
            }
        }
    }

}