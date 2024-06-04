package com.example.gettipcalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gettipcalculatorapp.components.BodyContentBox
import com.example.gettipcalculatorapp.components.HeaderBox
import com.example.gettipcalculatorapp.components.MyApp
import com.example.gettipcalculatorapp.ui.theme.GetTipCalculatorAppTheme
import com.example.gettipcalculatorapp.ui.theme.WhiteColor10

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetTipCalculatorAppTheme {
              MyApp()
            }
        }
    }
}