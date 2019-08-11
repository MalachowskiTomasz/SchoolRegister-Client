package com.engineers.school.register.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.engineers.school.register.entities.CourseSummary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class CourseSummaryRepository(private val courseRemoteRepository: CourseSummaryRemoteRepository) {

    private val executorService = Executors.newSingleThreadScheduledExecutor()

    private var studentId: Long? = null
    private val dataCache = MutableLiveData<List<CourseSummary>>()

    init {
        executorService.scheduleAtFixedRate({ update() }, 1, 10, TimeUnit.SECONDS)
    }

    fun getCourseSummaries(studentId: Long): LiveData<List<CourseSummary>> {
        this.studentId = studentId
        fetchCourseSummaries(studentId)
        return dataCache
    }

    private fun fetchCourseSummaries(studentId: Long) {
        courseRemoteRepository
            .getCourseSummaries(studentId)
            .enqueue(object : Callback<List<CourseSummary>> {
                override fun onResponse(call: Call<List<CourseSummary>>, response: Response<List<CourseSummary>>) {
                    dataCache.value = response.body()
                }

                override fun onFailure(call: Call<List<CourseSummary>>, t: Throwable) {
                    Log.e(javaClass.toString(), "Couldn't fetch dataCache from server")
                }
            })
    }

    private fun update() {
        if (studentId != null)
            fetchCourseSummaries(studentId!!)
    }
}