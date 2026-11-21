package com.example.learningnewconepts.ViewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TestingScreenViewModel(): ViewModel() {
    var items= mutableStateListOf<String>("Alvin","Alyster","Mary","Benedict")
        private set

    var itemstodiplay by mutableStateOf<List<String>>(emptyList())
        private set
    init{
        itemstodiplay=items
    }
    var text_to_display by mutableStateOf("")
        private set

    var issearchbarenabled by mutableStateOf(false)
        private set

    fun changetext(text: String){
        text_to_display=text
    }

    fun changeenabled(value: Boolean){
        issearchbarenabled=value
    }

    fun applyfilters(text: String){
        itemstodiplay=emptyList()
        itemstodiplay=items.filter { it.contains(text.trim(), ignoreCase = true) }
    }
}