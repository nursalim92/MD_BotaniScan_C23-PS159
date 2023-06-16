package com.capstone.botaniscan.data

import com.google.gson.annotations.SerializedName

data class PredictionResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: DataPrediction? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DataPrediction(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("confidence")
	val confidence: Any? = null,

	@field:SerializedName("prediction")
	val prediction: String? = null
)
