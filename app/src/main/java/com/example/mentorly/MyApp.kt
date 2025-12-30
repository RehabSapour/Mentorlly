package com.example.mentorly

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MyApp: Application() {
    val applicationScope = CoroutineScope(SupervisorJob()+ Dispatchers.IO)
}