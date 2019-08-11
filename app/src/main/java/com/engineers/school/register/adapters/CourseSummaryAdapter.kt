package com.engineers.school.register.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.engineers.school.register.R
import com.engineers.school.register.adapters.CourseSummaryAdapter.CourseSummaryViewHolder
import com.engineers.school.register.entities.CourseSummary

class CourseSummaryAdapter : RecyclerView.Adapter<CourseSummaryViewHolder>() {

    private val courseSummaries = mutableListOf<CourseSummary>()

    class CourseSummaryViewHolder(val view: ConstraintLayout) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseSummaryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.course_summary_item, parent, false) as ConstraintLayout
        return CourseSummaryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseSummaryViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.nameTextView).text = courseSummaries[position].name
        holder.view.findViewById<TextView>(R.id.averageMarkTextView).text = courseSummaries[position].averageMark.toString()
    }

    override fun getItemCount(): Int {
        return courseSummaries.size
    }

    fun updateItems(items: List<CourseSummary>) {
        courseSummaries.clear()
        courseSummaries.addAll(items)
        notifyDataSetChanged()
    }
}