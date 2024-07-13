package com.example.jettriviaapp.reposiotry

import android.util.Log
import com.example.jettriviaapp.data.DataOrException
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {

    private val dataOrException =
        DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        } catch (exception: Exception){
            dataOrException.exception = exception
            Log.d("Data Exc:", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        }
        return dataOrException
    }
}