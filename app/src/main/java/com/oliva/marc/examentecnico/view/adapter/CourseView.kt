package com.oliva.marc.examentecnico.view.adapter

import android.view.View
import com.oliva.marc.examentecnico.model.Course

interface CourseView {
    fun showCourses(courses:ArrayList<Course>)

    fun getCourses()
}