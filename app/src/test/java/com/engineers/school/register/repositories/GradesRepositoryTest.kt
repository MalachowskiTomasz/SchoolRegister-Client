package com.engineers.school.register.repositories

import com.engineers.school.register.entities.Grade
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class GradesRepositoryTest {

    @Mock
    lateinit var gradeRemoteRepository: GradeRemoteRepository

    lateinit var gradesRepository: GradesRepository

    @Before
    fun setUp() {
        gradesRepository = GradesRepository(gradeRemoteRepository)
    }

    @Test
    fun shouldGetGradesForStudent() {
        val call = mock<Call<List<Grade>>> {
            on { execute() }.thenReturn(Response.success(emptyList()))
        }
        whenever(gradeRemoteRepository.getGrades(any())).thenReturn(call)

        val result = gradesRepository.getGrades(123)

        assertThat(result).isEmpty()
    }
}