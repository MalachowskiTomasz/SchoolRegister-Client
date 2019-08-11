package com.engineers.school.register.repositories

class GradesRepository {
    val list: List<Int> = listOf(1, 2, 3, 4, 5)

    fun getGrades(studentId: Long): List<Int> {
        return list
    }
}