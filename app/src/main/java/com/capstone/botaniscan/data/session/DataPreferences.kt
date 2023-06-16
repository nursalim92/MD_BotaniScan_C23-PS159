package com.capstone.botaniscan.data.session

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getDataSession(): Flow<SessionLogin> {
        return dataStore.data.map { preferences ->
            SessionLogin (
                preferences[NAME_KEY] ?: "",
                preferences[TOKEN_KEY] ?: "",
                preferences[STATUS_KEY] ?: false
            )
        }
    }

    suspend fun saveDataSession(sessionLogin: SessionLogin) {
        dataStore.edit { preferences ->
            preferences[NAME_KEY] = sessionLogin.name
            preferences[TOKEN_KEY] = sessionLogin.token
            preferences[STATUS_KEY] = sessionLogin.isLogin
        }
    }

    suspend fun refreshToken(sessionLogin: SessionLogin) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = sessionLogin.token
        }
    }


    suspend fun login() {
        dataStore.edit { preferences ->
            preferences[STATUS_KEY] = true
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: DataPreferences? = null
        private val NAME_KEY = stringPreferencesKey("name")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val STATUS_KEY = booleanPreferencesKey("status")

        fun getInstance(dataStore: DataStore<Preferences>):DataPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = DataPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}