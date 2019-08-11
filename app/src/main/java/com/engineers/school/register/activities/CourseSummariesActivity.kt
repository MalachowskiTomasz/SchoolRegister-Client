package com.engineers.school.register.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.engineers.school.register.R
import com.engineers.school.register.adapters.CourseSummaryAdapter
import com.engineers.school.register.entities.CourseSummary
import com.engineers.school.register.viewModels.CourseSummaryViewModel
import kotlinx.android.synthetic.main.content_course_summaries.*
import org.koin.android.viewmodel.ext.android.viewModel

class CourseSummariesActivity : MenuActivity() {

    private val studentId = 123L

    private val courseSummaryViewModel: CourseSummaryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_course_summaries)
        title = getString(R.string.courses)

        courseSummaryViewModel.getCourseSummaries(studentId).observe(this, createCourseSummariesObserver())

        courseSummaryRecyclerView.adapter = CourseSummaryAdapter()
        courseSummaryRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun createCourseSummariesObserver(): Observer<List<CourseSummary>> {
        return Observer { courseSummaries ->
            (courseSummaryRecyclerView.adapter as CourseSummaryAdapter).updateItems(courseSummaries)
        }
    }
}
