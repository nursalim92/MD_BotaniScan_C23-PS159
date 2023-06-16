package com.capstone.botaniscan.model

import androidx.lifecycle.*
import com.auth0.jwt.JWT
import com.auth0.jwt.interfaces.DecodedJWT
import com.capstone.botaniscan.data.session.DataPreferences
import com.capstone.botaniscan.data.session.SessionLogin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class SessionViewModel (private val pref: DataPreferences) : ViewModel() {



        val token = MutableLiveData<String?>()

        init {
            viewModelScope.launch(Dispatchers.IO) {
                pref.getDataSession().collect {
                    withContext(Dispatchers.Main) {
//            val cekToken : DecodedJWT = JWT.decode(it.token)
//            if(cekToken.expiresAt.before(Date())){
//                 pref.logout()
                token.value = it.token
//            }


                    }
                }
            }
        }

    fun getSession(): LiveData<SessionLogin> {
        return pref.getDataSession().asLiveData()
    }



    fun saveSession(sessionLogin: SessionLogin) {
        viewModelScope.launch {
            pref.saveDataSession(sessionLogin)
        }
    }

    fun refreshTok(sessionLogin: SessionLogin) {
        viewModelScope.launch {
            pref.refreshToken(sessionLogin)

        }
    }

    fun removeSession() {
        viewModelScope.launch {
            pref.logout()
        }}
}
