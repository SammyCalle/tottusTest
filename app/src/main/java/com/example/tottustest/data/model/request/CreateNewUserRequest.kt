package com.example.tottustest.data.model.request

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class CreateNewUserRequest(
    var email : String,
    var password : String,
    var nombre : String,
    var apellido : String?
)