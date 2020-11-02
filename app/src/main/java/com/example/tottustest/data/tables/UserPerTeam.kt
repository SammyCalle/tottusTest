package com.example.tottustest.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "userperteam_table")
data class UserPerTeam(
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "userPerTeamId")
  var id : Int,
  @ColumnInfo(name = "userId")
  var userId : Int,
  @ColumnInfo(name = "teamId")
  var teamId : Int
)