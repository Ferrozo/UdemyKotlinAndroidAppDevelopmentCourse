package com.example.capstoneapp.repository

import com.example.capstoneapp.data.DataOrException
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.network.BookAPI
import javax.inject.Inject

class BookRepository @Inject constructor(private val api: BookAPI){

    private val dataOrException = DataOrException<List<Item>, Boolean, Exception>()
    private val bookInfoDataOrException = DataOrException<Item, Boolean, Exception>()
    suspend fun getBooks(searchQuery: String): DataOrException<List<Item>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getBooks(searchQuery).items
            if(dataOrException.data.isNullOrEmpty()) dataOrException.loading = false
        }catch (e: Exception){
            dataOrException.exception = e
        }
        return dataOrException
    }

    suspend fun getBookInfo(bookId: String): DataOrException<Item, Boolean, Exception> {
    try {
           bookInfoDataOrException.loading = true
           bookInfoDataOrException.data = api.getBookInfo(bookId = bookId)
           if (bookInfoDataOrException.data.toString().isNotEmpty())
               bookInfoDataOrException.loading = false
           else {}

        }catch (e: Exception){
           bookInfoDataOrException.exception = e
        }
        return bookInfoDataOrException
    }
}