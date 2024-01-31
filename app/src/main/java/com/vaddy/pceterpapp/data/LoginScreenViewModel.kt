package com.vaddy.pceterpapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


class LoginScreenViewModel:ViewModel() {

   // val loading = MutableStateFlow(LoadingState.IDLE)

    private val auth : FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)

    var loading : LiveData<Boolean> = _loading

    fun signIn(email:String, password: String, HomeScreen: ()-> Unit) =
        viewModelScope.launch {

                try {

                    auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener {task->
                            if (task.isSuccessful){
                               // TODO("take to Home Screen")
                                HomeScreen()
                            }
                            else{
                                Log.d("FB","signIn: ${task.result.toString()}")
                            }
                        }

                }catch (ex :Exception){
                    Log.d("FB","signIn: ${ex.message}")


                }

        }







}