package com.capstone.botaniscan.data


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginData(

//    @field:SerializedName("userId")
//    var iduser: String? = null,

    @field:SerializedName("name")
    var name: String?= null,

    @field:SerializedName("accessToken")
    var token: String?= null,

    var isLogin: Boolean = false
): Parcelable