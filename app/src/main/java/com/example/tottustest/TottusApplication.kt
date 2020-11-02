package com.example.tottustest

import android.app.Application
import com.example.tottustest.di.dataBaseModule
import com.example.tottustest.di.repositoryModule
import com.example.tottustest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TottusApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TottusApplication)
            modules(
                dataBaseModule,
                repositoryModule,
                viewModelModule
            )
        }
    }
}