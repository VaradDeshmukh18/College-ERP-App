package com.vaddy.pceterpapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vaddy.pceterpapp.data.DrawerMenueItems
import com.vaddy.pceterpapp.data.MenueList
import com.vaddy.pceterpapp.navigationGraph.NavScreenNames


@Composable
fun DrawerSheetContent(
    navController : NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(Color.White),

//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DrawerHead()

        Divider()

        DrawerBody(navController)

    }
}



@Composable
fun DrawerHead(){
    Row(
        modifier = Modifier.padding(15.dp)
    ) {
        CircNameCard()

        Spacer(modifier = Modifier.padding(horizontal = 10.dp))

        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Name",
                fontSize = 20.sp,
               // modifier = Modifier.padding(vertical = 5.dp)
            )
            Text(
                text = "Surname",
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Text(
                text = "pcet@pccoe.org",
                fontSize = 15.sp,
                modifier = Modifier.padding(vertical = 3.dp)
            )
        }
    }
}


@Composable
fun DrawerBody(
    navController : NavHostController
){

    Column(
        modifier = Modifier.fillMaxSize(),
       // verticalArrangement = Arrangement.Center,
       // horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
           // verticalArrangement = Arrangement.Center,
          //  horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(MenueList){menu->
                DrawerItemList(menu,navController)
            }

        }
    }
}

@Composable
fun DrawerItemList(
    drawerMenu: DrawerMenueItems,
    navController : NavHostController

){
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clickable {
                navController.navigate(NavScreenNames.Login.toString())
            },
        verticalAlignment = Alignment.CenterVertically,

    ){

        Icon(painter = painterResource(id = drawerMenu.icon), contentDescription = "Drawer menue icons")
//            Image(
//            painter = painterResource(id = drawerMenu.icon),
//            contentDescription ="Drawer menue icons",
//            modifier = Modifier.size(30.dp)
//        )
        Spacer(modifier = Modifier.padding(10.dp))

        Text(text = drawerMenu.item)
    }
}

//@Preview
//@Composable
//fun NwePrev(){
//    DrawerSheetContent()
//}