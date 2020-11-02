package com.example.tottustest.di

import android.app.Application
import androidx.room.Room
import com.example.tottustest.data.dao.TeamDao
import com.example.tottustest.data.dao.TeamMemberDao
import com.example.tottustest.data.dao.UserDataDao
import com.example.tottustest.data.dao.UserPerTeamDao
import com.example.tottustest.data.database.TottusDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBaseModule = module {

    fun provideDatabase(application: Application) : TottusDatabase{
        return Room.databaseBuilder(application, TottusDatabase::class.java , "tottus")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideTeamDao(database: TottusDatabase) : TeamDao {
        return database.teamDao()
    }

    fun provideTeamMemberDao(database: TottusDatabase) : TeamMemberDao {
        return database.teamMemberDao()
    }

    fun provideUserDataDao(database: TottusDatabase) : UserDataDao {
        return database.userDataDao()
    }

    fun provideUserPerTeamDao(database: TottusDatabase) : UserPerTeamDao {
        return database.userPerTeamDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideTeamDao(get()) }
    single { provideTeamMemberDao(get()) }
    single { provideUserDataDao(get()) }
    single { provideUserPerTeamDao(get()) }
}