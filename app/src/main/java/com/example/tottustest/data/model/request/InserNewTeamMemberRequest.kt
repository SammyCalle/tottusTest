package com.example.tottustest.data.model.request

import androidx.room.ColumnInfo


data class InserNewTeamMemberRequest(
    var email : String,
    var nombre : String,
    var teamId : Int
)