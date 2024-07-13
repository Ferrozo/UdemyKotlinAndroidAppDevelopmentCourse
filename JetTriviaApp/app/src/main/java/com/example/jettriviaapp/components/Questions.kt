package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.util.AppColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Questions(viewModel: QuestionsViewModel){
    val questions = viewModel.data.value.data?.toMutableList()

    val questionIndex = remember {
        mutableIntStateOf(0)
    }

    if(viewModel.data.value.loading!!){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ){
           Text(text = "Loading...")
        }

    }else  {
        val question = try {
            questions?.get(questionIndex.intValue)
        }catch (e: Exception){
            null
        }
        if(questions!!.isNotEmpty()){
        QuestionDisplay(
            question = question!!,
            viewModel = viewModel,
            questionIndex = questionIndex,
        ){
            questionIndex.intValue +=  1
        }
        }
    }

}