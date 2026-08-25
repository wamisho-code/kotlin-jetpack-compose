package com.example.myjetcompose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myjetcompose.model.UserDate
import com.example.myjetcompose.model.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    val userRepository: UserRepository= UserRepository()
    private val _userData= MutableStateFlow(UserDate("",0))
    val userDate: StateFlow<UserDate> = _userData.asStateFlow()

    private val _status= MutableStateFlow("")
    val status: StateFlow<String> =_status.asStateFlow()

    fun changeStatus(status:String){
        _status.value=status
    }


    fun changeUserDate(name:String,age: Int){
        _userData.value= _userData.value.copy(name = name, age = age)
    }
    fun getUserData(){
        viewModelScope.launch{
            val userResult=userRepository.fetchUserData()
            _userData.value.name=userResult.name
            _userData.value.age=userResult.age
        }
    }
}