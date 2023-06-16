package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class UsersData(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null


)
