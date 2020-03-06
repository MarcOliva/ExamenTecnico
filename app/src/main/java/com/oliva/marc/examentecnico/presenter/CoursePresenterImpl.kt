package com.oliva.marc.examentecnico.presenter

import com.oliva.marc.examentecnico.view.adapter.CourseView
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.model.interactor.CourseInteractorImpl
import com.oliva.marc.examentecnico.model.repository.CourseRepositoryImpl

class CoursePresenterImpl(val courseView: CourseView)  : CoursePresenter{
    private val courseInteractor = CourseInteractorImpl(this)
    override fun getCourses() {
        courseInteractor.getCourses()
    }

    override fun showCourses(courses: ArrayList<Course>) {
        courseView.showCourses(courses)
    }

}