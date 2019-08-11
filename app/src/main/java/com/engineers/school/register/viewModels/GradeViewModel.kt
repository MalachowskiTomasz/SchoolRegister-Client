package com.engineers.school.register.viewModels

import androidx.lifecycle.ViewModel
import com.engineers.school.register.entities.Grade
import com.engineers.school.register.repositories.GradesRepository

class GradeViewModel(val repository: GradesRepository) : ViewModel() {

    fun getGrades(studentId: Long): List<Grade> {
        return repository.getGrades(studentId)
    }

}