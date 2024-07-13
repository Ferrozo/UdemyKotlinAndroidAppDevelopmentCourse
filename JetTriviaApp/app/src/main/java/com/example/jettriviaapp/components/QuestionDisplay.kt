package com.example.jettriviaapp.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.model.QuestionItem
import com.example.jettriviaapp.screens.QuestionsViewModel
import com.example.jettriviaapp.util.AppColors

@Composable
fun QuestionDisplay(
    question: QuestionItem,
    questionIndex: MutableState<Int>,
    viewModel: QuestionsViewModel,
    onNextClicked: (Int) -> Unit
){
    val choiceState = remember(question){
        question.choices.toMutableList()
    }
    val answerState = remember(question){
        mutableStateOf<Int?>(null)
    }

    val correctAnswerState = remember(question){
        mutableStateOf<Boolean?>(null)
    }

    val updateAnswer: (Int) -> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswerState.value = choiceState[it] == question.answer
        }
    }

    Column(
        modifier = Modifier.verticalScroll(
            state = rememberScrollState(),
            enabled = true
        ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        QuizHeader(questionCount = questionIndex.value, questionOff = viewModel.data.value.data!!.count() )
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = question.question,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = AppColors.brownColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.fillMaxHeight(0.3f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            choiceState.forEachIndexed { index, choiceTitle ->
                QuizCard(
                    answer = choiceTitle,
                    onSelected = answerState.value == index,
                    isCorrect = correctAnswerState.value == true && answerState.value == index,
                    onClick = {
                        updateAnswer(index)
                    }
                    )
            }

            if(answerState.value != null && correctAnswerState.value == true){
                Spacer(modifier = Modifier.height(20.dp))
                MainButton(
                    title = "Next",
                    onClick = {
                        onNextClicked(questionIndex.value)
                    },
                    color = AppColors.brownColor
                )
            }
        }
    }

}