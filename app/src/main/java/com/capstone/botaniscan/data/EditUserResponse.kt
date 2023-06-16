package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class EditUserResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: UsersData? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)


