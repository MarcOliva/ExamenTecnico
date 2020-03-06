package com.oliva.marc.examentecnico.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oliva.marc.examentecnico.R
import com.oliva.marc.examentecnico.model.Course

class CourseRecyclerViewAdapter(val courses : ArrayList<Course>) :RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameCourse = itemView.findViewById<TextView>(R.id.course_name_textview)
        val codeCourse = itemView.findViewById<TextView>(R.id.course_code_textview)
        fun setDataCourse(course:Course){
            nameCourse.text = course.name
            codeCourse.text = course.code
        }
    }

    override fun getItemCount(): Int {
        return courses.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDataCourse(courses[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_course,
                parent,
                false
            )
        )
    }
}