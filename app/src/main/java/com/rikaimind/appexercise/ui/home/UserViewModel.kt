package com.rikaimind.appexercise.ui.home


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel@Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<User>())
    val state: StateFlow<List<User>>
        get() = _state


    init {
        viewModelScope.launch {
            val users = userRepo.getUsers()
            _state.value = users
        }


    }


//    var userListResponse:List<User> by mutableStateOf(listOf())
//    var errorMessage: String by mutableStateOf("")
//    var userDetailResponse: User? = null
//    fun getUserList() {
//        viewModelScope.launch {
//            val apiService = UserApi.getInstance()
//            try {
//                val movieList = apiService.getUsers()
//                userListResponse = movieList
//            }
//            catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }


//    fun getDetailUser() {
//        viewModelScope.launch {
//            val apiService = UserApi.getInstance()
//            try {
//                val user = apiService.getDetailUser()
//                userDetailResponse = user
//            }
//            catch (e: Exception) {
//                errorMessage = e.message.toString()
//            }
//        }
//    }

}