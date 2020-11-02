package com.example.tottustest.data.model.response

import androidx.annotation.Keep
import androidx.room.ColumnInfo

@Keep
data class SelectUsersFromTeamResponse(
    var id : Int,
    var teamId : Int
)