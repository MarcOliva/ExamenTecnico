package com.oliva.marc.examentecnico.model.interactor

import com.oliva.marc.examentecnico.view.adapter.CourseView
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.model.repository.CourseRepositoryImpl
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import com.oliva.marc.examentecnico.presenter.CoursePresenterImpl

class CourseInteractorImpl(coursePresenter:CoursePresenter) :CourseInteractor {
    private val courseRepository = CourseRepositoryImpl(coursePresenter)
    override fun getCourses() {
        courseRepository.getCourses()
    }

}