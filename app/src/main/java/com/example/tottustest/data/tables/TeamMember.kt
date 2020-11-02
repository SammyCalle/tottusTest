package com.example.tottustest.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teamMember_table")
data class TeamMember (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name = "teamId")
    var teamId : Int
)