package com.example.capstoneapp.network

import com.example.capstoneapp.models.BookModel
import com.example.capstoneapp.models.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface BookAPI {

    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): BookModel

    @GET("")
    suspend fun allBooks(): List<BookModel>

    @GET("volumes/{bookId}")
    suspend fun getBookInfo(@Path("bookId") bookId: String): Item

}