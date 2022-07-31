package com.rikaimind.appexercise.ui.detail

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.rikaimind.appexercise.data.api.model.User
import com.rikaimind.appexercise.data.api.model.UserDetail
import com.rikaimind.appexercise.ui.home.UserItem
import com.rikaimind.appexercise.ui.home.UserViewModel


@Composable
fun UserDetailScreenTest(userNameReceiver : String) {
    Text(
        text = userNameReceiver,
        style = MaterialTheme.typography.h3
    )
}
@Composable
fun UserDetailScreen() {
//    val userDetailViewModel = viewModel(modelClass = UserDetailViewModel::class.java)
//    val state by userDetailViewModel.state.collectAsState()

    val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //button close
            Icon(
                imageVector = Icons.Filled.Close,
                modifier =
                Modifier.size(64.dp)
                    .clickable {

                    }
                ,
                contentDescription = null
            )
            //avatar
            Image(
                painter = rememberImagePainter(
                    data = "https://avatars.githubusercontent.com/u/2?v=4",

                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.notification_action_background)
                        transformations(CircleCropTransformation())

                    }
                ),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )



            Spacer(modifier = Modifier.height(16.dp))
            Text(
//                text = userDetailViewModel.state.value.name,
                text = "defunkt",
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth(),
                thickness = 1.dp
            )


            //infor
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically

            ) {

                Icon(
                    imageVector = Icons.Filled.Person,
                    modifier = Modifier.size(64.dp),
                    contentDescription = null
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
//                                text = user.login,
                        text = "defunkt",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                    Box(
                        modifier = Modifier.
                        border(
                            BorderStroke(2.dp, Color.Red),
                            shape = RoundedCornerShape(8.dp)
                        )
                            .background(Color.Magenta)
                    ) {
                        Text(
//                                text = user.site_admin.toString(),
                            text = "false",
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier
                                .background(
                                    Color.LightGray
                                )
                                .padding(4.dp)

                        )
                    }


                }
            }



            //location
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    modifier = Modifier.size(64.dp),
                    contentDescription = null
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
//                                text = user.login,
                        text = "San Francisco",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )

                }
            }

            //blog
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    modifier = Modifier.size(64.dp),
                    contentDescription = null
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
//                                text = user.login,
                        text = "http://chriswanstrath.com/",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )

                }
            }


        }

}