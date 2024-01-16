package com.vaddy.pceterpapp.loginUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vaddy.pceterpapp.R
import com.vaddy.pceterpapp.fireBaseAuth.AuthViewModel
import com.vaddy.pceterpapp.navigationGraph.NavScreenNames

@Composable

fun Login(
    navController: NavHostController,
) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize()
            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(

                painter = painterResource(id = R.drawable.pcet),
                contentDescription ="pcet",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue
                        )
                    ) {
                        append("Sign")
                    }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF8700)
                        )
                    ) {
                        append("in")
                    }
                },
                fontSize = 30.sp
            )

        }

        Spacer(modifier = Modifier.height(20.dp))

            
        UserNameBox()


        Spacer(modifier = Modifier.height(8.dp))

        
        PasswordBox()


        Spacer(modifier = Modifier.height(50.dp))

        MyLoginButton(navController)


    }

}

@Composable
fun UserNameBox(){

    var username by remember { mutableStateOf("") }

    TextField(
        value = username,
        onValueChange = {username = it},
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape= OutlinedTextFieldDefaults.shape,
        label = {
            Text(text = "Username")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "username"
            )
        },

        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        )

    )
}

@Composable
fun PasswordBox(){
    var password by remember { mutableStateOf("") }

    var passwordVisibility by remember{
        mutableStateOf(false)
    }

    TextField(
        value = password,
        onValueChange = {password = it},
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = {
            Text(text = "Password")
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "username"
            )
        },

        visualTransformation =  if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),

        trailingIcon = {
            Image(
                painter = painterResource(
                    if (passwordVisibility) R.drawable.visibilityoff
                    else R.drawable.visibility
                ),
                contentDescription = if (passwordVisibility) "Hide Password" else "Show Password",
                
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                    passwordVisibility = !passwordVisibility
                }
            )
        },



    )
}

@Composable
fun MyLoginButton(
    navController: NavHostController,
) {


    ElevatedButton(
        onClick = {
            navController.navigate(NavScreenNames.Home.toString())
        },
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3a0ca3)
        )
    ) {
        Text(
            text = "Log in",
            fontSize = 22.sp
        )
    }

}

