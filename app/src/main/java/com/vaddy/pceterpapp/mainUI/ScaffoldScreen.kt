package com.vaddy.pceterpapp.mainUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaddy.pceterpapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffScreen(drawerState: DrawerState, scope: CoroutineScope) {

    Scaffold (
        modifier = Modifier.fillMaxSize(),

        topBar = {
           MyTopBar(drawerState,scope)

        }

    ){

        Column (
            modifier = Modifier
                .padding(it)
                .background(Color.White)
        ){

           LazyVerticalGrid(
               columns = GridCells.Fixed(2),
               modifier = Modifier
                   .fillMaxSize()
                   .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
               userScrollEnabled= true
           ){
               items(ModuleList){module->
                   Module(module)
               }
           }
        }
    }
}




@Composable
fun MyTopBar(
        drawerState: DrawerState, scope: CoroutineScope
) {

    Column(
        modifier = Modifier
            .fillMaxWidth().height(150.dp)
            .background(Color(232, 234, 246))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.profileavatar),
                contentDescription = "",
                modifier = Modifier.size(50.dp).clip(CircleShape)
            )

            Spacer(modifier = Modifier.padding(horizontal = 8.dp))

            Text(
                "Name Surname Name",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                modifier = Modifier.wrapContentSize(),
                fontWeight = FontWeight.W500

            )

            Spacer(modifier = Modifier.weight(1f))

//            Image(
//                painter = painterResource(id = R.drawable.pccoelogo),
//                contentDescription = "",
//                modifier = Modifier.size(50.dp),
//                alignment = Alignment.CenterEnd
//            )

        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){

            IconButton(
                onClick = {
                scope.launch {
                    drawerState.open()
                }
            }
            ){
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Hamburger icon",
                    modifier = Modifier.size(30.dp)
                )

            }

            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Column(
                //horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Registration  121B1B000",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 17.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    "B.Tech Kabutar Science",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 17.sp
                )
            }


        }
    }
}

@Preview
@Composable
fun My(){
//   MyTopBar()
}
