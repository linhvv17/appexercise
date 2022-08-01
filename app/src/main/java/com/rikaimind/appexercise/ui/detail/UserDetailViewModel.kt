package com.rikaimind.appexercise.ui.detail


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikaimind.appexercise.data.api.model.UserDetail
import com.rikaimind.appexercise.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel
@Inject constructor(
    private val userRepo: UserRepo,
) : ViewModel() {


        private val _state = MutableStateFlow(
            UserDetail(
        "",
        "",
        "",
        "",
        false,
        "",
        "",
    )
        )
    val state: StateFlow<UserDetail>
        get() = _state

    init {

        viewModelScope.launch {
            val user = userRepo.getUserDetail(userName = "wycats")
            _state.value = user
        }
    }

}