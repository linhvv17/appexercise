package com.rikaimind.appexercise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.rikaimind.appexercise.ui.detail.UserDetailScreen
import com.rikaimind.appexercise.ui.detail.UserDetailScreenTest
import com.rikaimind.appexercise.ui.home.UserListScreen
import com.rikaimind.appexercise.ui.theme.AppExerciseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class UserDetailActivity : ComponentActivity() {

    companion object{
        private const val userNameId = "userName"
        fun intent(context: Context, userName: String)=
            Intent(context,UserDetailActivity::class.java).apply {
                putExtra(userNameId,userName)
            }
    }

    private val userName: String by lazy {
        intent?.getSerializableExtra(userNameId) as String
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppExerciseTheme {
                Surface(color = MaterialTheme.colors.background) {
//                UserDetailScreenTest(
//                    userNameReceiver = userName
//                )
                    UserDetailScreen(userName)
                }
            }

        }
    }
}