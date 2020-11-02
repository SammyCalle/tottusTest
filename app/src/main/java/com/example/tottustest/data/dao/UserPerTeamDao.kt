package com.example.tottustest.data.dao

import androidx.room.*
import com.example.tottustest.data.model.request.DeleteUserFromTeamRequest
import com.example.tottustest.data.model.request.InserNewTeamUserRequest
import com.example.tottustest.data.model.response.SelectUsersFromTeamResponse

@Dao
interface UserPerTeamDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewTeamUser(newUser : InserNewTeamUserRequest)

    @Query("SELECT * FROM userperteam_table where userId = :idInput")
    fun selectUsersFromTeam( idInput : Int) : List<SelectUsersFromTeamResponse>

    @Delete
    fun deleteUserFromTeam(user : DeleteUserFromTeamRequest)

}