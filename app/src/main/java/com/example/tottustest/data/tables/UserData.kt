package com.example.tottustest.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "userdata_table")
data class UserData(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int,
    @ColumnInfo(name = "email")
    var email : String,
    @ColumnInfo(name = "password")
    var password : String,
    @ColumnInfo(name = "nombre")
    var nombre : String,
    @ColumnInfo(name = "apellido")
    var apellido : String?
)