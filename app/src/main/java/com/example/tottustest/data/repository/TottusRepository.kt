package com.example.tottustest.data.repository

import com.example.tottustest.data.model.request.*
import com.example.tottustest.data.model.response.*
import com.example.tottustest.utils.AppResult

interface TottusRepository{
    suspend fun  userLogin(emailInput: String, passwordInput : String ) : AppResult<ValidateLoginResponse?>

    suspend fun createNewUser(newUser: CreateNewUserRequest)

    suspend fun getUserofCertainTeam(idInput : Int) : AppResult<GetUserOfCertainTeamResponse?>

    suspend fun createNewTeam(newTeamRequest : CreateNewTeamRequest)

    suspend fun selectTeamIfExist(idInput : Int) : AppResult<SelectTeamIfExistResponse?>

    suspend fun insertNewTeamMember(teamMember : InserNewTeamMemberRequest)

    suspend fun selectMembersFromTeam(idInput: Int): AppResult<List<SelectMembersFromTeamResponse>?>

    suspend fun deleteTeamMember(teamMember: DeleteMemberFromTeamRequest)

    suspend fun insertNewTeamUser(newUser: InserNewTeamUserRequest)

    suspend fun selectUsersFromTeam(idInput: Int) : AppResult<List<SelectUsersFromTeamResponse>?>

    suspend fun deleteUserFromTeam(user: DeleteUserFromTeamRequest)
}