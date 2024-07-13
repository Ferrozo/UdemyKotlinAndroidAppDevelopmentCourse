package com.example.jettriviaapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jettriviaapp.components.Questions
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettriviaapp.components.QuizHeader
import com.example.jettriviaapp.util.AppColors

@Preview(showBackground = true)
@Composable
fun HomeScreen(viewModel: QuestionsViewModel = hiltViewModel()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AppColors.pinkBgColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Questions(viewModel)
        }
    }
}