package com.rikaimind.appexercise.data.api

import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.api.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET(ApiConstants.USERS_END_POINTS)
    suspend fun getUsers() : List<User>
    //@Path("id") id: String,

    @GET(ApiConstants.USERS_END_POINTS+"/{username}")
    suspend fun getDetailUser(@Path("username") username: String) : UserDetail

//    @GET("users")
//    suspend fun getDetailUser() : User

//    companion object {
//        var apiService: UserApi? = null
//        fun getInstance() : UserApi {
//            if (apiService == null) {
//                apiService = Retrofit.Builder()
//                    .baseUrl("https://api.github.com/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build().create(UserApi::class.java)
//            }
//            return apiService!!
//        }
//    }
}