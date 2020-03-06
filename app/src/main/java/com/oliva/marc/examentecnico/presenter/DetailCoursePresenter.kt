package com.oliva.marc.examentecnico.presenter

import com.oliva.marc.examentecnico.model.Entity.Course

interface DetailCoursePresenter {
    fun getDetailCourse(course: Course)
    fun setUpCourse(course:Course)
}