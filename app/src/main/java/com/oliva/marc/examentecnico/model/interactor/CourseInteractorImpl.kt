package com.oliva.marc.examentecnico.model.interactor

import com.oliva.marc.examentecnico.view.adapter.CourseView
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.presenter.CoursePresenterImpl

class CourseInteractorImpl :CourseInteractor,
    CourseView {
    private val presenterImpl = CoursePresenterImpl(this)
    override fun getCourses() {
        presenterImpl.getCourses()
    }

    override fun showCourses(courses: ArrayList<Course>) {
        presenterImpl.showCourses(courses)
    }

}