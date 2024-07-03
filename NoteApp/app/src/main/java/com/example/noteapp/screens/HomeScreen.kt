package com.example.noteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteapp.NoteViewModel

@Composable
fun HomeScreen(){

    val noteViewModel: NoteViewModel = hiltViewModel()
    val notesList = noteViewModel.noteList.collectAsState().value
    LazyColumn {
        items(count = notesList.size){
            Text(text = notesList[it].title)
        }
    }

}

//@Preview
//@Composable
//fun HomeHeaderPreview(){
//    HomeScreen()
//}