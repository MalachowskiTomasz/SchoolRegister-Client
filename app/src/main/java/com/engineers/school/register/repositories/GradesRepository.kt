package com.engineers.school.register.repositories

import com.engineers.school.register.entities.Grade

class GradesRepository(private val gradesRemoteRepository: GradeRemoteRepository) {

    fun getGrades(studentId: Long): List<Grade> {
        return gradesRemoteRepository
            .getGrades(studentId)
            .execute()
            .body()!!
    }
}