package com.example.learningnewconepts.ViewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningnewconepts.ViewModels.Sharedprefviewmodel

class SharedPrefViewModelFactory(val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Sharedprefviewmodel::class.java)){
            return Sharedprefviewmodel(application) as T
        }
        else{
            throw IllegalArgumentException("Invalid class")
        }
    }
}