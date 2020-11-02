package com.example.tottustest.data.repository

import android.content.Context
import com.example.tottustest.data.dao.TeamDao
import com.example.tottustest.data.dao.TeamMemberDao
import com.example.tottustest.data.dao.UserDataDao
import com.example.tottustest.data.dao.UserPerTeamDao
import com.example.tottustest.data.model.request.*
import com.example.tottustest.data.model.response.*
import com.example.tottustest.utils.AppResult
import com.example.tottustest.utils.noDataError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TottusRepositoryImpl(private val context : Context
                           , private val userPerTeamDao: UserPerTeamDao
                           , private val userDataDao: UserDataDao,private val teamDao: TeamDao
                           , private val teamMemberDao: TeamMemberDao) : TottusRepository {

    override suspend fun userLogin(
        emailInput: String,
        passwordInput: String
    ): AppResult<ValidateLoginResponse?> {
        val data = withContext(Dispatchers.IO) {
            userDataDao.validateLogin(emailInput, passwordInput)
        }
        return if(!data?.nombre.isNullOrEmpty()){
            AppResult.Success(data)
        }else{
            context.noDataError()
        }
    }

    override suspend fun createNewUser(newUser: CreateNewUserRequest) {
        withContext(Dispatchers.IO){
            userDataDao.createrNewUser(newUser)
        }
    }

    override suspend fun getUserofCertainTeam(idInput: Int): AppResult<GetUserOfCertainTeamResponse?>{
        val data = withContext(Dispatchers.IO){
            userDataDao.getUsersofCertainTeam(idInput)
        }
        return if(!data?.nombre.isNullOrEmpty()){
            AppResult.Success(data)
        }else{
            context.noDataError()
        }
    }

    override suspend fun createNewTeam(newTeamRequest: CreateNewTeamRequest) {
        withContext(Dispatchers.IO){
            teamDao.createNewTeam(newTeamRequest)
        }
    }

    override suspend fun selectTeamIfExist(idInput: Int): AppResult<SelectTeamIfExistResponse?> {
        val data = withContext(Dispatchers.IO){
            teamDao.selectTeamIfExist(idInput)
        }
        return if(!data?.name.isNullOrEmpty()){
            AppResult.Success(data)
        }else{
            context.noDataError()
        }
    }

    override suspend fun insertNewTeamMember(teamMember: InserNewTeamMemberRequest) {
        withContext(Dispatchers.IO){
            teamMemberDao.inserNewTeamMember(teamMember)
        }
    }

    override suspend fun selectMembersFromTeam(idInput: Int): AppResult<List<SelectMembersFromTeamResponse>?>{
        val data = withContext(Dispatchers.IO){
            teamMemberDao.selectMembersFromTeam(idInput)
        }
        return if(!data.isEmpty()){
            AppResult.Success(data)
        }else{
            context.noDataError()
        }
    }

    override suspend fun deleteTeamMember(teamMember: DeleteMemberFromTeamRequest) {
        withContext(Dispatchers.IO){
            teamMemberDao.deleteTeamMember(teamMember)
        }
    }

    override suspend fun insertNewTeamUser(newUser: InserNewTeamUserRequest) {
        withContext(Dispatchers.IO){
            userPerTeamDao.insertNewTeamUser(newUser)
        }
    }

    override suspend fun selectUsersFromTeam(idInput: Int): AppResult<List<SelectUsersFromTeamResponse>?>{
        val data = withContext(Dispatchers.IO){
            userPerTeamDao.selectUsersFromTeam(idInput)
        }
        return if(!data.isEmpty()){
            AppResult.Success(data)
        }else{
            context.noDataError()
        }
    }

    override suspend fun deleteUserFromTeam(user: DeleteUserFromTeamRequest) {
        withContext(Dispatchers.IO) {
            userPerTeamDao.deleteUserFromTeam(user)
        }
    }
}