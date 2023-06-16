package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class RegisterRespon(
    @field:SerializedName("code")
    val code: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("message")
    val message: String
)
