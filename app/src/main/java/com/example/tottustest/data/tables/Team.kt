package com.example.tottustest.data.tables

import androidx.room.*

@Entity( tableName = "team_table")
data class Team(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "teamId")
    var id: Int,
    @ColumnInfo(name = "teamName")
    var name : String,
    @ColumnInfo(name = "teamphrase")
    var phrase : String
)
