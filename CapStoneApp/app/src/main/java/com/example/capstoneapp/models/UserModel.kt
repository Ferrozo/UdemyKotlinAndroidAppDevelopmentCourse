package com.example.capstoneapp.models

data class UserModel(
    val uid: String,
    val email: String,
    val displayName: String,
    val photoUrl: String? ="",
    val quote: String? ="",
    val profession: String? =""
){

    fun toMap(): MutableMap<String, Any?>{
        return mutableMapOf(
            "uid" to this.uid,
            "email" to this.email,
            "displayName" to this.displayName,
            "photoUrl" to this.photoUrl,
            "quote" to this.quote,
        )
    }
}
