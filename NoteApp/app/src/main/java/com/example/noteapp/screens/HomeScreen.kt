package com.example.noteapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController : NavController
){
    val notesList = NoteViewModel().getAllNotes()
    
    LazyColumn {
        items(count = notesList.size){
            Text(text = notesList[it].title)
        }
    }

}

@Preview
@Composable
fun HomeHeaderPreview(){
    HomeScreen(navController = rememberNavController())
}