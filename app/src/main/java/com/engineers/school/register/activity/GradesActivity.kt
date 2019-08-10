package com.engineers.school.register.activity

import android.os.Bundle
import com.engineers.school.register.R

class GradesActivity : MenuActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_grades)
        title = "Oceny"
    }
}
