package com.engineers.school.register.viewModels

import androidx.lifecycle.ViewModel
import com.engineers.school.register.repositories.GradesRepository

class GradeViewModel(val repo: GradesRepository) : ViewModel() {

    fun getGrades(studentId: Long): List<Int> {
        return repo.getGrades(studentId)
    }

}