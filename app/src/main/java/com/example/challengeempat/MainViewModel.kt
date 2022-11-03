package com.example.challengeempat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _isLogin: MutableLiveData<Boolean> = MutableLiveData()
    val isLogin: LiveData<Boolean> get() = _isLogin

    fun setLogin(value: Boolean){
        _isLogin.postValue(value)
    }
}