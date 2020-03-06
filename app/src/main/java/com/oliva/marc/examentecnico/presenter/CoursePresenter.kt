package com.oliva.marc.examentecnico.presenter

import com.oliva.marc.examentecnico.model.Course

interface CoursePresenter {
    fun getCourses()
    fun showCourses(courses:ArrayList<Course>)
}