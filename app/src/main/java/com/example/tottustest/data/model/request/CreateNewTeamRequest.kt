package com.example.tottustest.data.model.request

import androidx.room.ColumnInfo

data class CreateNewTeamRequest(
    var id: Int,
    var name : String,
    var phrase : String
)