package com.example.learningnewconepts.Screens

import android.app.Application
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningnewconepts.ViewModels.Sharedprefviewmodel

@Composable
fun SharePref(viewmodel: Sharedprefviewmodel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()
            .background(if(viewmodel.theme=="Light")Color.White else Color.Yellow)
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically)) {
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text("Dark Mode",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color=Color.Black)
                Spacer(modifier = Modifier.width(5.dp))
                Box(modifier = Modifier.size(50.dp)
                    .clip(CircleShape)) {
                    IconButton(onClick = {
                        viewmodel.editSharedpref()
                    },
                        modifier = Modifier.fillMaxSize()) {
                        Icon(imageVector =if(viewmodel.theme=="Light") Icons.Default.RadioButtonUnchecked else Icons.Default.RadioButtonChecked,"null",
                            modifier = Modifier.fillMaxSize())
                    }
                }

            }

        }
    }
}