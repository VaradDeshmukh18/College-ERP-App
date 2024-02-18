package com.vaddy.pceterpapp.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vaddy.pceterpapp.R
import com.vaddy.pceterpapp.navigation.NavScreenNames
import kotlinx.coroutines.delay

@Composable

fun SplashScreen(
    navController: NavHostController,
    //viewModel : LoginScreenViewModel = androidx.lifecycle.view model.compose.viewModel(),
    ) {

    val scale =  remember{
        Animatable(0f)
    }

    LaunchedEffect(key1 = true ){
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )
            )
        delay(2000L)

        navController.navigate(NavScreenNames.Login.name)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            
        color = Color(0xFFf1faee)
    ) {

        Column(
            modifier = Modifier
                .padding(15.dp)
                .scale(scale.value)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
    
            Image(
                painter = painterResource(id = R.drawable.pccoelogo), 
                contentDescription = "College img",
                modifier = Modifier
                    .size(150.dp)
            )
            
            Spacer(modifier = Modifier.padding(10.dp))
            
            Image(
                painter = painterResource(id = R.drawable.college),
                contentDescription = "College img",

            )
        }
    }

}
