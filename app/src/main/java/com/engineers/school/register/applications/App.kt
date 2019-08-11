package com.engineers.school.register.applications

import android.app.Application
import android.os.StrictMode
import com.engineers.school.register.repositories.CourseSummaryRemoteRepository
import com.engineers.school.register.repositories.CourseSummaryRepository
import com.engineers.school.register.viewModels.CourseSummaryViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    private val appModule = module {

        single {CourseSummaryRepository(CourseSummaryRemoteRepository.create())}

        viewModel {
            CourseSummaryViewModel(get())
        }
    }

    override fun onCreate() {
        super.onCreate()
        setThreadPolicy()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }

    private fun setThreadPolicy() {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }
}