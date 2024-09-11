package com.example.capstoneapp.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.capstoneapp.components.EmailInputField
import com.example.capstoneapp.components.OrangeButton
import com.example.capstoneapp.components.PasswordInputField
import com.example.capstoneapp.navigation.AppScreens
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.OrangeColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel,
){
    val password = rememberSaveable { mutableStateOf("") }
    val email = rememberSaveable { mutableStateOf("") }
    val isValid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    val scaffoldState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = scaffoldState)
        },
        modifier = Modifier.fillMaxSize()) {
        Surface(

            color = BackgroundColor,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {

            if(viewModel.loading.value == true){
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    CircularProgressIndicator(
                        color =OrangeColor
                    )
                }
            }else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center

                    ){
                        Text("KARITA",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Black,
                                color = DarkBlueColor
                            )
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text("Reader",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = DarkBlueColor
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text("To use your account, you need to log in first",
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            color = TextGrayColor
                        )
                    )
                    Spacer(modifier = Modifier.height(80.dp))
                    EmailInputField(email= email)
                    Spacer(modifier = Modifier.height(15.dp))
                    PasswordInputField(password = password)
                    Spacer(modifier = Modifier.height(15.dp))
                    OrangeButton(modifier = Modifier,"Login",
                        onClick = {
                            if (isValid) {
                                viewModel.signInWithEmailAndPassword(email.value, password.value){
                                    navController.navigate(AppScreens.HomeScreen.name)
                                }
                            } else {
                                scope.launch {
                                    scaffoldState.showSnackbar(
                                        "Please make sure you have valid credentials",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        },
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Don't have an account?",
                            style = TextStyle(
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                color = TextGrayColor
                            )
                        )
                        TextButton(
                            onClick =
                            {
                                navController.navigate(AppScreens.SignUpScreen.name)
                            }
                        ) {
                            Text("Sign up",
                                style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    fontSize = 16.sp,
                                    color = OrangeColor
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}