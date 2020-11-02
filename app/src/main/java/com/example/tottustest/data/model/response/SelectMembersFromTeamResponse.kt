package com.example.tottustest.data.model.response

import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class SelectMembersFromTeamResponse(
    var id : Int,
    var email : String,
    var nombre : String,
    var teamId : Int
)