package com.example.capstoneapp.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    private  var auth: FirebaseAuth = Firebase.auth
    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit)
    = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                _loading.value = false
                if (task.isSuccessful){
                    home()
                }
            }.addOnFailureListener {
                _loading.value = false
            }
        }catch (error: Exception){
            print("$error")
        }
    }

    fun signOut()
    = viewModelScope.launch{
        try {
            auth.signOut()
        }catch (error: Exception){
            print("$error")
        }
    }
}