package com.rikaimind.appexercise

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.ui.theme.AppExerciseTheme
import com.rikaimind.appexercise.ui.home.UserItem
import com.rikaimind.appexercise.ui.home.UserListScreen
import com.rikaimind.appexercise.ui.home.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UserListScreen{
                        startActivity(UserDetailActivity.intent(this,it.login))
                    }

                }
            }
        }
    }
}

