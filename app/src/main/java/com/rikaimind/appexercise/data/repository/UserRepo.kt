package com.rikaimind.appexercise.data.repository

import com.rikaimind.appexercise.data.api.UserApi
import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.api.model.UserDetail
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun getUsers(): List<User> {
        return userApi.getUsers()
    }

    suspend fun getUserDetail(userName : String): UserDetail {
        return userApi.getDetailUser(username = userName)
    }
}