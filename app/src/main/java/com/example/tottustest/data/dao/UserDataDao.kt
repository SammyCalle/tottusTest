package com.example.tottustest.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tottustest.data.model.request.CreateNewUserRequest
import com.example.tottustest.data.model.response.GetUserOfCertainTeamResponse
import com.example.tottustest.data.model.response.ValidateLoginResponse

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun createrNewUser(newUser : CreateNewUserRequest)

    @Query("SELECT id,nombre,apellido FROM userdata_table WHERE email = :emailInput AND password= :passwordInput ")
    fun validateLogin(emailInput:String , passwordInput:String) : ValidateLoginResponse?

    @Query("SELECT id,nombre,apellido FROM userdata_table WHERE id = :idInput ")
    fun getUsersofCertainTeam(idInput : Int) : GetUserOfCertainTeamResponse


}