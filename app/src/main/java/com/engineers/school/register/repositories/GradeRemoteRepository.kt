package com.engineers.school.register.repositories

import com.engineers.school.register.entities.Grade
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface GradeRemoteRepository {
    companion object {
        fun create(): GradeRemoteRepository {
            return Retrofit.Builder()
                .baseUrl(server)
                .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
                .build()
                .create(GradeRemoteRepository::class.java)
        }
    }

    @GET("students/{id}/grades")
    fun getGrades(@Path("id") studentId: Long): Call<List<Grade>>
}
