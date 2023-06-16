package com.capstone.botaniscan.data.session

data class SessionLogin(
    var name: String,
    val token: String,
    val isLogin: Boolean
)
