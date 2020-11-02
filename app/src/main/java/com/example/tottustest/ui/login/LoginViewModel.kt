package com.example.tottustest.ui.login

import androidx.lifecycle.MutableLiveData
import com.example.tottustest.data.repository.TottusRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tottustest.data.model.response.ValidateLoginResponse
import com.example.tottustest.utils.AppResult
import kotlinx.coroutines.launch


class LoginViewModel(private val repository : TottusRepository) : ViewModel() {


    val userData = MutableLiveData<ValidateLoginResponse?>()
    val showError = MutableLiveData<String>()

    fun userLogin(emailInput: String, passwordInput: String
    ){
        viewModelScope.launch {
            val result  = repository.userLogin(emailInput,passwordInput)
            when(result){
                is AppResult.Success ->{
                    userData.value = result.successData
                }
                is AppResult.Error ->{
                    showError.value = result.exception.message
                }
            }
        }
    }
}