package com.engineers.school.register.entities

import kotlinx.serialization.Serializable

@Serializable
data class CourseSummary(val id: Long, val name: String, val averageMark : Float)