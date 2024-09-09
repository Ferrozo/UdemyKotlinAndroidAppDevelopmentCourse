package com.example.capstoneapp.repository

import com.example.capstoneapp.data.Resource
import com.example.capstoneapp.models.BookModel
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.network.BookAPI
import javax.inject.Inject

class BookRepository @Inject constructor(private val api: BookAPI){

    suspend fun getBooks(searchQuery: String): Resource<List<Item>>{
        val response = try {
            Resource.Loading(data = true)
            val itemList = api.getBooks(searchQuery).items
            if(itemList.isNotEmpty())  Resource.Loading(data = false)
            Resource.Success(data = itemList)
        }catch (exception: Exception){
           Resource.Error(message = exception.toString())
        }
        return response
    }

    suspend fun getAllBooks(): Resource<List<BookModel>>{
        val response = try {
            Resource.Loading(data = true)
            val itemList = api.allBooks()
            if(itemList.isNotEmpty())  Resource.Loading(data = false)
            Resource.Success(data = itemList)
        }catch (exception: Exception){
            Resource.Error(message = exception.toString())
        }
        return response
    }

    suspend fun getBookInfo(bookId: String): Resource<Item> {
    val response = try {
            Resource.Loading(data = true)
            val item = api.getBookInfo(bookId)
            Resource.Success(data = item)
        }catch (exception: Exception){
            Resource.Error(message = "An error occurred ${exception.message.toString()}")
        }
        Resource.Loading(data = false)
        return response
    }
}