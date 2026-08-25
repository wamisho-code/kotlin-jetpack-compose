package com.example.myjetcompose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MyViewModel : ViewModel(){
    private var _nameState = MutableStateFlow("")
    val nameState= _nameState.asStateFlow()

    fun loadName(){
        viewModelScope.launch {
            Log.d("Effects","loadName()")
            delay(1500)
            _nameState.update { "Wamisho" }
        }
    }
    fun addToName(){
        _nameState.update { it+" new" }
    }
}