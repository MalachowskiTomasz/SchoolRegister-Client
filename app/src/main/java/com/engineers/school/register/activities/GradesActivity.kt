package com.engineers.school.register.activities

import android.os.Bundle
import com.engineers.school.register.R
import com.engineers.school.register.viewModels.GradeViewModel
import kotlinx.android.synthetic.main.content_grades.*
import org.koin.android.viewmodel.ext.android.viewModel

class GradesActivity : MenuActivity() {

    val gradeViewModel: GradeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_grades)
        title = "Oceny"
        textView2.text = gradeViewModel.getGrades(123).toString()
    }
}
