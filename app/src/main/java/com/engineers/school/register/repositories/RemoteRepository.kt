package com.engineers.school.register.repositories

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType

const val server = "http://192.168.0.206:8080"
val converter = Json.asConverterFactory(MediaType.get("application/json"))