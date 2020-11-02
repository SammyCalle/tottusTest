package com.example.tottustest.di

import com.example.tottustest.ui.login.LoginViewModel
import com.example.tottustest.ui.registration.RegistrationViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        LoginViewModel(repository = get())
        RegistrationViewModel(repository = get())
    }
}