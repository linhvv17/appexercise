package com.rikaimind.appexercise.ui.feature.users


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel@Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {

    var state by mutableStateOf(
        UsersContract.State(
            users = listOf(),
            isLoading = true
        )
    )
        private set

    var effects = Channel<UsersContract.Effect>(Channel.UNLIMITED)
        private set


    init {
        viewModelScope.launch {
            val users = userRepo.getUsers()
            state = state.copy(users = users, isLoading = false)
            effects.send(UsersContract.Effect.DataWasLoaded)
        }


    }


}