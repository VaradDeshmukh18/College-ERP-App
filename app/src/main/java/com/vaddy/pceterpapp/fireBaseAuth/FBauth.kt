package com.vaddy.pceterpapp.fireBaseAuth

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await


class AuthViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()

    suspend fun registerUser(email: String, password: String): Boolean {
        return try {
            auth.createUserWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    suspend fun loginUser(email: String, password: String): Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    fun checkLoggedInState(): Boolean {
        return auth.currentUser != null
    }
}
