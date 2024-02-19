package com.vaddy.pceterpapp.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun InputField(

    modifier: Modifier = Modifier,
    value: String,
    onValueChange : (String)->Unit,
    enable: Boolean = true,
    imeAction : ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    singleLine :Boolean = true,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon :  @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
){

    TextField(
        value = value,
        onValueChange =onValueChange,
        singleLine = singleLine,
        modifier= modifier,
        shape= OutlinedTextFieldDefaults.shape,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon=trailingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions=keyboardActions,
    )

}



@Composable
fun EmailInput(

    modifier: Modifier = Modifier,
    emailState : String,
    onValueChange : (String)->Unit,
    enable: Boolean = true,
    imeAction : ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    singleLine :Boolean = true,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon :  @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,

    ){


    InputField(
        value = emailState,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label,
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
    )

}

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password : String,
    onValueChange : (String)->Unit,
    enable: Boolean = true,
    imeAction : ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
    singleLine :Boolean = true,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon :  @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
){
    InputField(
        value = password,
        onValueChange =onValueChange,
        singleLine = singleLine,
        modifier = modifier,
        label = label,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

