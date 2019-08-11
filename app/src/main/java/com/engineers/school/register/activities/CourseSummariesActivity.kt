package com.engineers.school.register.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import com.engineers.school.register.R
import com.engineers.school.register.entities.CourseSummary
import com.engineers.school.register.viewModels.CourseSummaryViewModel
import kotlinx.android.synthetic.main.content_course_summaries.*
import org.koin.android.viewmodel.ext.android.viewModel

class CourseSummariesActivity : MenuActivity() {

    private val courseSummaryViewModel: CourseSummaryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_course_summaries)
        title = "Kursy"

        courseSummaryViewModel.getCourseSummaries(123).observe(this, createCourseSummariesObserver())
    }

    private fun createCourseSummariesObserver(): Observer<List<CourseSummary>> {
        return Observer { courseSummaries ->
            textView2.text = courseSummaries.toString()
        }
    }
}
