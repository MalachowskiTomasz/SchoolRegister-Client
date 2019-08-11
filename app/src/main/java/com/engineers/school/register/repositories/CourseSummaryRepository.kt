package com.engineers.school.register.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.engineers.school.register.entities.CourseSummary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseSummaryRepository(private val courseRemoteRepository: CourseSummaryRemoteRepository) {

    fun getCourseSummaries(studentId: Long): LiveData<List<CourseSummary>> {
        val data = MutableLiveData<List<CourseSummary>>()
        courseRemoteRepository
            .getCourseSummaries(studentId)
            .enqueue(object : Callback<List<CourseSummary>> {
                override fun onResponse(call: Call<List<CourseSummary>>, response: Response<List<CourseSummary>>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<List<CourseSummary>>, t: Throwable) {
                    TODO()
                }
            })
        return data
    }
}