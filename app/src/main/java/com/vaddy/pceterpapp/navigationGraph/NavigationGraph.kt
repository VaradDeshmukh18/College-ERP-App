package com.vaddy.pceterpapp.navigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.vaddy.pceterpapp.loginUi.Login
import com.vaddy.pceterpapp.ui.screens.DrawerNav


@Composable
fun NavDisplay(
     navController : NavHostController
){


    NavHost(navController = navController, startDestination = NavScreenNames.Login.toString()){

        composable(route=NavScreenNames.Login.toString()){
            Login(navController = navController)
        }

        composable(route=NavScreenNames.Home.toString()){
            DrawerNav(navController = navController)
        }


//        composable(route="Screen2"){
//           // Screen2(navController = navController)
//        }

    }


}