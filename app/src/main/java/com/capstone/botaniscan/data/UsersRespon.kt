package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class UsersRespon(
    @field:SerializedName("code")
    val code: Int? = null,
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("data")
    val data: List<UsersData?>? = null

)

