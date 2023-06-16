package com.capstone.botaniscan.model

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.botaniscan.api.ApiConfig
import com.capstone.botaniscan.data.EditUserResponse
import com.capstone.botaniscan.data.UsersRespon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersViewModel : ViewModel() {

  val dataUsers = MutableLiveData<UsersRespon>()
    fun setDataUsers(token : String){
        ApiConfig.getApiService().getUser(token)
            .enqueue(object : Callback<UsersRespon> {
                override fun onResponse(call: Call<UsersRespon>, response: Response<UsersRespon>) {
                    if (response.isSuccessful) {
                        dataUsers.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<UsersRespon>, t: Throwable) {

                }
            })
    }
                fun getDataUsers() : LiveData<UsersRespon>{
                    return dataUsers
                }

}