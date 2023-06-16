package com.capstone.botaniscan.data

data class DetailHistoryResponse(

    val code: Int? = null,
    val data: DataDetailHistory? = null,
    val message: String? = null,
    val status: String? = null
)

data class DataDetailHistory(
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

