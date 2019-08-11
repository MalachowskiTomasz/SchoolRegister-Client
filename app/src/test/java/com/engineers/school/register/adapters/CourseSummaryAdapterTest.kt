package com.engineers.school.register.adapters

import com.engineers.school.register.entities.CourseSummary
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class CourseSummaryAdapterTest {

    lateinit var courseSummaryAdapter: CourseSummaryAdapter

    @Before
    fun setUp() {
        courseSummaryAdapter = CourseSummaryAdapterForTest()
    }

    @Test
    fun shouldUpdateItems() {
        val list = listOf(
            CourseSummary(1, "Biologia", 5.5F),
            CourseSummary(2, "Matematyka", 4.5F)
        )

        courseSummaryAdapter.updateItems(list)

        assertThat(courseSummaryAdapter.courseSummaries)
            .containsExactlyInAnyOrderElementsOf(list)
    }

    class CourseSummaryAdapterForTest : CourseSummaryAdapter() {
        override fun notifyChanged() {}
    }
}