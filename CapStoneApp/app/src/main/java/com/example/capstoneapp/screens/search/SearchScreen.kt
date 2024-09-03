package com.example.capstoneapp.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.capstoneapp.components.HorizontalBookCard
import com.example.capstoneapp.components.SearchBox
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.DarkBlueColor


@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchBookViewModel
){
    val onValueChange = remember {
        mutableStateOf("")
    }

    val searchResult = remember {
        mutableStateOf(viewModel.listOfBooks)
    }

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = BackgroundColor,
        ) {
            Column(
                modifier =
                Modifier
                    .verticalScroll(state = rememberScrollState())
                    .padding(vertical = 10.dp)
            ) {

                    IconButton(
                        onClick = { navController.popBackStack()}
                    ) {
                        Icon(
                            Icons.Default.ArrowBack ,
                            contentDescription =null,
                            tint = DarkBlueColor,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                Spacer(modifier = Modifier.height(10.dp))
                    SearchBox(
                        value = onValueChange.value,
                        onValueChange = {
                            newValue -> onValueChange.value = newValue
                        },
                        enabled = true,
                        onSearch = {
                            viewModel.searchBooks(onValueChange.value)
                        }
                    )
                if(viewModel.listOfBooks.value.loading == true)
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = "Loading...")
                    }
                else
                Column (
                    modifier = Modifier.padding(horizontal = 20.dp)
                ){
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text= "Your search result",
                        style = TextStyle(
                            color = Color.Black.copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    LazyColumn {

                    }
                }
            }
        }
    }
}