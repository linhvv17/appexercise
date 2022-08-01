package com.rikaimind.appexercise.ui.home

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.rikaimind.appexercise.UserDetailActivity
import com.rikaimind.appexercise.data.api.model.User



@Composable
fun UserListScreen(selectedItem: (User) -> Unit) {
    val userViewModel = viewModel(modelClass = UserViewModel::class.java)
    val state by userViewModel.state.collectAsState()

    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }

        }

        items(
            items = state.take(100),//limit 100 items
            itemContent = {
                UserItem(user = it, selectedItem = selectedItem)
            }
        )


    }

}



@Composable
fun UserItem(user: User, selectedItem: (User) -> Unit) {
    Card(
        modifier = Modifier
            .clickable {
                Log.d("click item", "CLICK")
//                startActivity(Intent(rememberCompositionContext, UserDetailActivity::class.java))
            }
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .clickable { selectedItem(user) },
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = user.avatar_url,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.notification_action_background)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = user.login,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = user.login,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    if (!user.site_admin){
                        Text(
                            color = Color.White,
                            text = "STAFF",
                            style = MaterialTheme.typography.caption,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .width(80.dp)
                                .height(30.dp)
                                .padding(4.dp)
                                .background(color = Color.Blue, shape = RoundedCornerShape(15.dp))
                        )
                    }

                }
            }
        }
    }

}