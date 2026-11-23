package com.example.learningnewconepts.ViewModels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class Sharedprefviewmodel(application: Application): AndroidViewModel(application) {
    var sharedpref=application.getSharedPreferences("MyPref", Application.MODE_PRIVATE)
        private set

    var theme by mutableStateOf<String>("Light")
        private set

    fun editSharedpref(){
        if(theme=="Light"){
            sharedpref.edit {
                putString("Theme","Dark")
            }
            theme=sharedpref.getString("Theme","")?:"Dark"
        }
        else{
            sharedpref.edit{
                putString("Theme","Light")
            }
            theme=sharedpref.getString("Theme","")?:"Light"
        }
    }

    fun CurrentTheme(){
        theme=sharedpref.getString("Theme","Light")?:"Light"
    }

    init{
        CurrentTheme()
    }
}