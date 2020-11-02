package com.example.tottustest.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tottustest.data.model.request.CreateNewTeamRequest
import com.example.tottustest.data.model.response.SelectTeamIfExistResponse

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun createNewTeam(newTeamRequest : CreateNewTeamRequest)

    @Query("SELECT * FROM team_table WHERE teamId = :idInput ")
    fun selectTeamIfExist(idInput : Int) : SelectTeamIfExistResponse
}