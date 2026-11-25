package com.example.learningnewconepts.Screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IntentsScreen() {
    val context= LocalContext.current
    Box(modifier= Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically)) {
            Text("Open YouTube",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
            Button(onClick = {
                val intent= Intent(Intent.ACTION_VIEW).apply {
                    data= Uri.parse("https://www.youtube.com/")
                    context.startActivity(this)
                }
            },
                shape = RoundedCornerShape(16.dp),

            ) {
                Text("Click Here")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Open Dial",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
            Button(onClick = {
                val intent= Intent(Intent.ACTION_DIAL).apply {
                    data= Uri.parse("tel:+9845310315")
                    try{
                        context.startActivity(this)
                    }
                    catch (e: Exception){
                    println(e)
                    }

                }
                },
                shape = RoundedCornerShape(16.dp),

                ) {
                Text("Click Here")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Send Mail",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
            Button(onClick = {
               val intent= Intent(Intent.ACTION_SEND).apply {
                   type="text/plain"
                   putExtra(Intent.EXTRA_SUBJECT,"I am sending to test")
                   putExtra(Intent.EXTRA_TEXT,"Hello There")
               }
                val messegeselector= Intent.createChooser(intent,"Share via")
                context.startActivity(messegeselector)
            },
                shape = RoundedCornerShape(16.dp),

                ) {
                Text("Click Here")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Open Maps",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
            Button(onClick = {
                val intent= Intent(Intent.ACTION_VIEW).apply {
                    data= Uri.parse("geo:Hubballi, Karnataka, India")
                    try {
                        context.startActivity(this)
                    }
                    catch (e: Exception){
                        Toast.makeText(context,"${e}", Toast.LENGTH_SHORT).show()
                    }

                }
                val messegeselector= Intent.createChooser(intent,"Share via")
                context.startActivity(messegeselector)
            },
                shape = RoundedCornerShape(16.dp),

                ) {
                Text("Click Here")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text("Open YouTube App",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontStyle = FontStyle.Italic)
            Button(onClick = {
                val intent=Intent(Intent.ACTION_MAIN).apply {
                    setPackage("com.google.android.youtube")
                    context.startActivity(this)
                    try {
                        context.startActivity(this)
                    }
                    catch (e: Exception){
                        Toast.makeText(context,"${e}", Toast.LENGTH_SHORT).show()
                    }
                }
            },
                shape = RoundedCornerShape(16.dp),

                ) {
                Text("Click Here")
            }
        }
    }
}