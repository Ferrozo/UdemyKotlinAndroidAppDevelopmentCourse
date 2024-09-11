package com.example.capstoneapp.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import com.example.capstoneapp.components.DetailBookCard
import com.example.capstoneapp.components.DetailTopBar
import com.example.capstoneapp.components.OrangeButton
import com.example.capstoneapp.data.Resource
import com.example.capstoneapp.models.Item
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.OrangeColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.ui.theme.WhiteColor

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
       bottomBar = {
           Box(
               modifier = Modifier.background(color = WhiteColor)
           ){
               OrangeButton(modifier = Modifier.padding(20.dp), title = "Start Reading", onClick = {})
           }
       },
       modifier = Modifier.fillMaxSize()
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
               val cleanBookDescriptionFromHTMLTags = HtmlCompat.fromHtml(book.data!!.volumeInfo.description, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
               Column (
                   modifier = Modifier
                       .padding(horizontal = 20.dp)
                       .verticalScroll(state = rememberScrollState())
                       .fillMaxSize()
               ){
                   Spacer(modifier = Modifier.height(20.dp))
                   DetailTopBar(navController = navController)
                   Spacer(modifier = Modifier.height(40.dp))
                   DetailBookCard(book = book.data)
                   Spacer(modifier = Modifier.height(20.dp))
                   Text(
                       text = "Description",
                       style = TextStyle(
                           fontSize = 18.sp,
                           color = Color.Black
                           )
                   )
                   Spacer(modifier = Modifier.height(20.dp))
                   Text(
                       text = cleanBookDescriptionFromHTMLTags,
                       style = TextStyle(
                           fontSize = 12.sp,
                           color = TextGrayColor
                       )
                       )
                   }

           }
       }
   }
}