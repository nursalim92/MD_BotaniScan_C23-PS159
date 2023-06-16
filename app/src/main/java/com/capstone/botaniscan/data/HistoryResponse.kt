package com.capstone.botaniscan.data

data class HistoryResponse(
	val code: Int? = null,
	val data: ArrayList<DataHistory>,
	val message: String? = null,
	val status: String? = null
)

data class DataHistory(
	val solution: String? = null,
	val prediction_id: String? = null,
	val img_url: String? = null,
	val disease_desc: String? = null,
	val accuration: Any? = null,
	val disease_name: String? = null,
	val plant_desc: String? = null,
	val plant_name: String? = null,
	val created_at: String? = null
)

