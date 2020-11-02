package com.example.tottustest.data.dao

import androidx.room.*
import com.example.tottustest.data.model.request.DeleteMemberFromTeamRequest
import com.example.tottustest.data.model.request.InserNewTeamMemberRequest
import com.example.tottustest.data.model.response.SelectMembersFromTeamResponse

@Dao
interface TeamMemberDao{

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun inserNewTeamMember(teamMember : InserNewTeamMemberRequest)

    @Query("SELECT * FROM teamMember_table WHERE teamId = :idInput")
    fun selectMembersFromTeam(idInput : Int) : List<SelectMembersFromTeamResponse>

    @Delete
    fun deleteTeamMember(teamMember : DeleteMemberFromTeamRequest)
}