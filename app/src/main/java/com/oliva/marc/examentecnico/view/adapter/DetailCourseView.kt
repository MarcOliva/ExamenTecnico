package com.oliva.marc.examentecnico.view.adapter

import com.oliva.marc.examentecnico.model.Entity.Course

interface DetailCourseView {
    fun getDetailCourse(course: Course)
    fun setUpCourse(course:Course)
}