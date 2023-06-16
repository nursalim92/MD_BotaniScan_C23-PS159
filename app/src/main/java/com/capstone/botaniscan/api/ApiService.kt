package com.capstone.botaniscan.api

import com.capstone.botaniscan.data.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @Multipart
    @POST("prediction/corn")
    fun predictionImageCorn(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
    ): Call<PredictionResponse>

    @Multipart
    @POST("prediction/potato")
    fun predictionImagePotato(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
    ): Call<PredictionResponse>

    @Multipart
    @POST("prediction/pepper")
    fun predictionImagePapper(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
    ): Call<PredictionResponse>

    @FormUrlEncoded
    @POST("register")
    fun regis(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterRespon>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginRespon>

    @FormUrlEncoded
    @POST("refresh")
    fun refreshToken(
        @Header("Authorization") token: String,
    ): Call<LoginRespon>


    @GET("users")
    fun getUser(
        @Header("Authorization") token: String,
    ): Call<UsersRespon>

    @FormUrlEncoded
    @PUT("users")
    fun editUser(
        @Header("Authorization") token: String,
        @Field("name") name: String,
        @Field("email") email: String
    ): Call<EditUserResponse>


    @FormUrlEncoded
    @PUT("users/changePassword")
    fun editPass(
        @Header("Authorization") token: String,
        @Field("oldPassword") oldPass: String,
        @Field("newPassword") newPass: String,
        @Field("confirmPassword") confirm: String
    ): Call<EditPassResponse>

    @GET("history")
    fun getHistory(
        @Header("Authorization") token: String,
    ): Call<HistoryResponse>

    @GET("history/{id}")
    fun getHistoryId(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<DetailHistoryResponse>

    @GET("store")
    fun getStore(
        @Header("Authorization") token: String,
    ): Call<StoreResponse>


}