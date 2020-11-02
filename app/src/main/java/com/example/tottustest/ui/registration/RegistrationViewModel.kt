package com.example.tottustest.ui.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tottustest.data.model.request.CreateNewUserRequest
import com.example.tottustest.data.repository.TottusRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository : TottusRepository) : ViewModel() {

    val created = MutableLiveData<Boolean>()

    fun createUser(newUser : CreateNewUserRequest
    ){
        viewModelScope.launch {
            val result  = repository.createNewUser(newUser)
            created.value = true
        }
    }
}