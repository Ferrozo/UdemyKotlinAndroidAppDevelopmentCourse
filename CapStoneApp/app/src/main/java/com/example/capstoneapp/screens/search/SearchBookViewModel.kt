package com.example.capstoneapp.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel@Inject constructor(private val repository: BookRepository): ViewModel() {

    val list:List<Item> = mutableListOf()
    init {
        loadBooks()
    }

    private fun loadBooks(){
        searchBooks("")
    }
     fun searchBooks(query: String){
        viewModelScope.launch(Dispatchers.Default) {
            if(query.isEmpty()){
                return@launch
            }

        }
    }

}