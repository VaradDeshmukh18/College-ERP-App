package com.vaddy.pceterpapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vaddy.pceterpapp.ui.components.DrawerSheetContent
import com.vaddy.pceterpapp.ui.screens.ScaffScreen


@Composable
fun DrawerNav(
    navController : NavHostController
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.wrapContentSize(),
                drawerShape = RoundedCornerShape(0.dp),
            ){
                DrawerSheetContent(navController)
            }
        },
        drawerState = drawerState,
    ) {
        ScaffScreen(drawerState,scope)
    }

}

@Preview
@Composable
fun MyPrev(){

    DrawerNav( rememberNavController())
}