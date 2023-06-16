package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class LoginRespon (
    @field:SerializedName("code")
    val code: String,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: LoginData? = null

)
