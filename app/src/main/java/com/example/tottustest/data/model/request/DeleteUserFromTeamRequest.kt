package com.example.tottustest.data.model.request

import androidx.room.ColumnInfo

data class DeleteUserFromTeamRequest (
    var id : Int,
    var userId : Int,
    var teamId : Int
)