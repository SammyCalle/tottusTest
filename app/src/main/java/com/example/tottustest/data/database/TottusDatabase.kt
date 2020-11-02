package com.example.tottustest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tottustest.data.dao.TeamDao
import com.example.tottustest.data.dao.TeamMemberDao
import com.example.tottustest.data.dao.UserDataDao
import com.example.tottustest.data.dao.UserPerTeamDao
import com.example.tottustest.data.tables.Team
import com.example.tottustest.data.tables.TeamMember
import com.example.tottustest.data.tables.UserData
import com.example.tottustest.data.tables.UserPerTeam

@Database(entities = [UserData::class, Team::class, TeamMember::class , UserPerTeam::class], version = 1,exportSchema = false)
abstract class TottusDatabase : RoomDatabase(){

    abstract fun teamDao() : TeamDao
    abstract fun teamMemberDao() : TeamMemberDao
    abstract fun userDataDao() : UserDataDao
    abstract fun userPerTeamDao() : UserPerTeamDao

}