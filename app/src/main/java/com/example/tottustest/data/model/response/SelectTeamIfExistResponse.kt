package com.example.tottustest.data.model.response

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@Keep
data class SelectTeamIfExistResponse(
    var id: Int,
    var name : String,
    var phrase : String
)