package com.example.capstoneapp.screens.signup

import android.content.ContentValues.TAG
import android.util.Log
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
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading
    private lateinit var auth: FirebaseAuth

    fun signUpWithEmailAndPassword(email:String, password: String, home: ()-> Unit)
    = viewModelScope.launch {
        auth = Firebase.auth
        try {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(){ task ->
                    if(task.isSuccessful){
                        _loading.value = false
                        home()
                    }else{
                        task.exception?.localizedMessage
                    }
                }
        }catch (error: Exception){
            error.localizedMessage?.let { Log.w(TAG, it) }
        }
    }

}