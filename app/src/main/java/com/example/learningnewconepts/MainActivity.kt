package com.example.learningnewconepts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningnewconepts.Screens.SharePref
import com.example.learningnewconepts.Screens.TestingScreen
import com.example.learningnewconepts.ViewModels.Sharedprefviewmodel
import com.example.learningnewconepts.ui.theme.LearningNewConeptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningNewConeptsTheme {
                val viewmodel: Sharedprefviewmodel= viewModel{
                    Sharedprefviewmodel(application)
                }
                SharePref(viewmodel)
            }
        }
    }
}
