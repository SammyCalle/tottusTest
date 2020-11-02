package com.example.tottustest.data.model.request

import androidx.room.ColumnInfo


data class InserNewTeamUserRequest(
    var userId : Int,
    var teamId : Int
)