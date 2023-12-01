package com.app.ghostretrofit

import android.app.Application
import com.app.ghostretrofit.viewmodel.RecycleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class GhostApp:Application() {
    override fun onCreate() {
        super.onCreate()
        //dependency injection для додатку
        startKoin {
            androidContext(this@GhostApp)
            androidLogger()
            modules(myModule)
        }

    }

    private val myModule = module {
        viewModel { RecycleViewModel(get()) }
    }
}