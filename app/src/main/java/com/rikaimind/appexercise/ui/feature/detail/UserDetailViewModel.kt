package com.rikaimind.appexercise.ui.feature.detail


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikaimind.appexercise.data.repository.UserRepo
import com.rikaimind.appexercise.ui.NavigationKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel
@Inject constructor(
    private val stateHandle: SavedStateHandle,
    private val userRepo: UserRepo,
) : ViewModel() {

    var state by mutableStateOf(
        UserDetailsContract.State(
            null
        )
    )

    init {
        viewModelScope.launch {
            val userName = stateHandle.get<String>(NavigationKeys.Arg.USER_NAME)
                ?: throw IllegalStateException("No userName was passed to destination.")
            val userDetail = userRepo.getUserDetail(userName)
            state = state.copy(userDetail = userDetail)
        }
    }

}