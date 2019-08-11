package com.engineers.school.register.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.engineers.school.register.entities.CourseSummary
import com.engineers.school.register.repositories.CourseSummaryRepository

class CourseSummaryViewModel(private val repository: CourseSummaryRepository) : ViewModel() {
    fun getCourseSummaries(studentId: Long): LiveData<List<CourseSummary>> {
        return repository.getCourseSummaries(studentId)
    }
}
