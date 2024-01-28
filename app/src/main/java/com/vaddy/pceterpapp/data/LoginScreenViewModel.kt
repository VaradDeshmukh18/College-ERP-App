package com.vaddy.pceterpapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginScreenViewModel:ViewModel() {

   // val loading = MutableStateFlow(LoadingState.IDLE)

    private val auth : FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)

    var loading : LiveData<Boolean> = _loading



}