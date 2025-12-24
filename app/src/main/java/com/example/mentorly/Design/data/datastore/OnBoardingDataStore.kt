package com.example.mentorly.Design.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "onboarding")


object OnBoardingKeys {
    val COMPLETED = booleanPreferencesKey("completed")
}
suspend fun saveOnBoardingState(context: Context){
    context.dataStore.edit { preferences ->
        preferences[OnBoardingKeys.COMPLETED] = true
    }
}


fun readOnBoardingState(context: Context): Flow<Boolean> {
    return context.dataStore.data.map { preferences ->
        preferences[OnBoardingKeys.COMPLETED] ?: false
    }
}