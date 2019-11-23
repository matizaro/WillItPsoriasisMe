package com.example.myapplication.app

import android.app.Application
import com.example.myapplication.main.MainActivityVM.Companion.mainActivityModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PsoriasisApp : Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@PsoriasisApp)
            // modules
            modules(listOf(psoriasisModule, mainActivityModule))
        }
    }
}