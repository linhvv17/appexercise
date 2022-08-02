package com.rikaimind.appexercise.data.api

import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.api.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface UserApi {

    //get list of users
    @GET(ApiConstants.USERS_END_POINTS)
    suspend fun getUsers() : List<User>

    //get user details
    @GET(ApiConstants.USERS_END_POINTS+"/{username}")
    suspend fun getDetailUser(@Path("username") username: String) : UserDetail
}