package com.engineers.school.register.applications

import android.app.Application
import com.engineers.school.register.repositories.GradesRepository
import com.engineers.school.register.viewModels.GradeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    val appModule = module {
        single { GradesRepository() }

        viewModel {
            GradeViewModel(get())
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}