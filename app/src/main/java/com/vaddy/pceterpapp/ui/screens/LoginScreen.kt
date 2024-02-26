package com.vaddy.pceterpapp.ui.screens

import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vaddy.pceterpapp.R
import com.vaddy.pceterpapp.data.LoginScreenViewModel
import com.vaddy.pceterpapp.data.NavScreenNames
import com.vaddy.pceterpapp.ui.components.EmailInput
import com.vaddy.pceterpapp.ui.components.PasswordInput
import com.vaddy.pceterpapp.ui.components.rememberImeState

@Composable

fun LoginScreen(
    navController: NavHostController,
    viewModel : LoginScreenViewModel= androidx.lifecycle.viewmodel.compose.viewModel(),
    
) {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value){
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }


    val showLoginForm = rememberSaveable { mutableStateOf(true) }

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

        LoginTextImage()

        Spacer(modifier = Modifier.height(20.dp))

        if (showLoginForm.value)
            UserForm(loading=false,
                isCreateAccount = false,
                navController,
                ){ email, password ->
                viewModel.signIn(email, password){
                    navController.navigate(NavScreenNames.Home.name)
                }
            }

        else{
            UserForm(loading=false,
                isCreateAccount = true,
                navController,
            ){ email, password ->
                viewModel.createUserWithEmailAndPassword(email, password) {
                    navController.navigate(NavScreenNames.Home.name)
                }
            }
        }










    }

}

@Composable
@Stable
private fun LoginTextImage(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.pcet),
            contentDescription = stringResource(R.string.PCET),
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        LoginScreenText()
    }
}


@Composable
fun UserForm(
    loading: Boolean = false,
    isCreateAccount: Boolean = false,
    navController: NavHostController,
    onDone: (String, String) -> Unit = { email, pwd ->},
){

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current
    val localFocusManager = LocalFocusManager.current

    val valid = remember(email,password){
        email.trim().isNotEmpty() && password.trim().isNotEmpty()
    }

    val modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)



    EmailInput(
        emailState = email,
        onValueChange  = {email=it},
        modifier = modifier,
        label = { Text(text = stringResource(R.string.UserName))},
        leadingIcon = {Icon(
            imageVector = Icons.Default.Person,
            contentDescription = stringResource(R.string.UserName)
        )},
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next
        )
    )

    Spacer(modifier = Modifier.height(10.dp))

    PasswordInput(
        password = password,
        onValueChange = {password=it},
        modifier = modifier,
        label = {Text(text = stringResource(R.string.login_input_password))},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "password"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(
                    if (!passwordVisibility) R.drawable.visibilityoff
                    else R.drawable.visibility
                ),
                contentDescription = if (!passwordVisibility) stringResource(R.string.hide_password) else stringResource(
                    R.string.show_password
                ),

                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        passwordVisibility = !passwordVisibility
                    }
            )
        },
        visualTransformation =  if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(

            onDone = {
                localFocusManager.clearFocus()
                email.trim()
                password.trim()
                keyboardController?.hide()
            }
        ),

    )

    Spacer(modifier = Modifier.height(20.dp))

    LoginButton(
        text = stringResource(R.string.log_in),
        navController= navController,
        loading = false,
        validInputs = valid,
    )

}


@Composable
fun LoginButton(
    text:String = "",
    validInputs:Boolean,
    loading:Boolean = false,
    navController: NavHostController,

) {


    ElevatedButton(
        onClick = {
          navController.navigate(NavScreenNames.Home.toString())
        },
        modifier = Modifier
            .width(180.dp)
            .height(50.dp),
        enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3a0ca3)
        )
    ) {


        if(loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        else{
            Text(
                text = text,
                fontSize = 22.sp
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun LogPreview(){

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize()
            .padding(16.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){

        LoginScreen(navController = rememberNavController())

    }


}

@Composable
@Stable
fun LoginScreenText(){
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.Blue
                )
            ) {
                append(stringResource(R.string.SignIn))
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