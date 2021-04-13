package com.realworld.io.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.realworld.api.models.objects.User
import com.realworld.io.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    private val _user =MutableLiveData<User?>()
    val user:LiveData<User?> get() = _user

    fun onLoginClicked(email:String, password:String){
        viewModelScope.launch {

            val userResponse = UserRepo.login(email,password)
            _user.value = userResponse.body()?.user

        }
    }

    fun onSignUpClicked(username:String, email:String, password:String) {
        viewModelScope.launch {

            val userResponse = UserRepo.signUp(username, email, password)
            _user.value = userResponse.body()?.user

        }
    }
}