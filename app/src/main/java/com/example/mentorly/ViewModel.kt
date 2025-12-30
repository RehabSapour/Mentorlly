package com.example.mentorly

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentorly.Design.data.datastore.saveOnBoardingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {

    fun saveOnBoarding(context: Context){
        viewModelScope.launch(Dispatchers.IO){
            saveOnBoardingState(context)
        }
    }

}