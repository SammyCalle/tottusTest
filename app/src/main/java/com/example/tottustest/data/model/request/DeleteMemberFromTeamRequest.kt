package com.example.tottustest.data.model.request

import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class DeleteMemberFromTeamRequest(
    var id : Int,
    var email : String,
    var nombre : String,
    var teamId : Int
)