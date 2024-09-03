package com.example.capstoneapp.screens.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.capstoneapp.data.DataOrException
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel@Inject constructor(private val repository: BookRepository): ViewModel() {

    val listOfBooks: MutableState<DataOrException<List<Item>, Boolean, Exception>>
    = mutableStateOf(DataOrException(null,  true,  Exception()))

    init {
        searchBooks("")
    }
     fun searchBooks(query: String){
        viewModelScope.launch(Dispatchers.IO) {
            if(query.isEmpty()){
                return@launch
            }
            listOfBooks.value.loading =true
            listOfBooks.value = repository.getBooks(query)
            if(listOfBooks.value.data.toString().isNotEmpty()) listOfBooks.value.loading = false
        }
    }

}