package com.example.tottustest.di

import android.content.Context
import com.example.tottustest.data.dao.TeamDao
import com.example.tottustest.data.dao.TeamMemberDao
import com.example.tottustest.data.dao.UserDataDao
import com.example.tottustest.data.dao.UserPerTeamDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    fun provideTottusRepository(context : Context, userPerTeamDao: UserPerTeamDao
                                ,userDataDao: UserDataDao, teamDao: TeamDao
                                ,teamMemberDao: TeamMemberDao){
        return provideTottusRepository(context,userPerTeamDao,userDataDao,teamDao
            ,teamMemberDao)
    }
    single { provideTottusRepository(androidContext(), get(),get()
        ,get(),get()) }
}