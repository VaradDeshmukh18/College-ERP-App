package com.vaddy.pceterpapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vaddy.pceterpapp.ui.screens.DrawerNav
import com.vaddy.pceterpapp.ui.screens.LoginScreen
import com.vaddy.pceterpapp.ui.screens.SplashScreen


@Composable
fun NavDisplay(
     navController : NavHostController
){


    NavHost(navController = navController, startDestination = NavScreenNames.SplashScreen.toString()){


        composable(route=NavScreenNames.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(route=NavScreenNames.Login.name){
            LoginScreen(navController = navController)
        }

        composable(route=NavScreenNames.Home.name){
            DrawerNav(navController = navController)
        }

    }
}