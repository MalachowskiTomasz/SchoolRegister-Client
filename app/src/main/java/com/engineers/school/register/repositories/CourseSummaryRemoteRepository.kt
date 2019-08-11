package com.engineers.school.register.repositories

import com.engineers.school.register.entities.CourseSummary
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface CourseSummaryRemoteRepository {
    companion object {
        fun create(): CourseSummaryRemoteRepository {
            return Retrofit.Builder()
                .baseUrl(server)
                .addConverterFactory(converter)
                .build()
                .create(CourseSummaryRemoteRepository::class.java)
        }
    }

    @GET("students/{id}/courses")
    fun getCourseSummaries(@Path("id") studentId: Long): Call<List<CourseSummary>>
}
