package com.example.capstoneapp.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.capstoneapp.components.DetailBookCard
import com.example.capstoneapp.components.DetailTopBar
import com.example.capstoneapp.components.OrangeButton
import com.example.capstoneapp.data.Resource
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.OrangeColor

@Composable
fun DetailScreen(
    navController: NavController,
    bookId: String?,
    viewModel: DetailViewModel
){
  val book = produceState<Resource<Item>>(initialValue = Resource.Loading() ) {
    value = viewModel.getBookInfo(bookId!!)
  }.value
   Scaffold(
       topBar = {
           DetailTopBar(navController = navController )
       },
       bottomBar = {
           OrangeButton(title = "Start Reading", onClick = {})
       }
   ) {
       Surface(
           color = BackgroundColor,
           modifier = Modifier
               .padding(it)
               .fillMaxSize()
       ) {
           if(book.data == null) {
               Column (
                   verticalArrangement = Arrangement.Center,
                   horizontalAlignment = Alignment.CenterHorizontally,
                   modifier = Modifier.fillMaxSize()
               ){
                   CircularProgressIndicator(
                       color = OrangeColor
                   )
               }
           } else {
               Column (
                   modifier = Modifier
                       .verticalScroll(state = rememberScrollState())
                       .fillMaxSize()
               ){
                   DetailBookCard(book = book.data)
               }
           }
       }
   }
}