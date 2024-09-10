package com.example.capstoneapp.screens.detail

import androidx.lifecycle.ViewModel
import com.example.capstoneapp.data.Resource
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: BookRepository): ViewModel() {
    suspend fun getBookInfo(bookId: String): Resource<Item> {
        return repository.getBookInfo( bookId= bookId)
    }
}