package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class StoreResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: ArrayList<DataItemStore>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataItemStore(

	@field:SerializedName("store_id")
	val storeId: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("contact")
	val contact: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("onlineshop")
	val onlineshop: String? = null
)
