package com.oliva.marc.examentecnico.model.interactor.Impl

import com.oliva.marc.examentecnico.model.interactor.CourseInteractor
import com.oliva.marc.examentecnico.model.repository.CourseRepositoryImpl
import com.oliva.marc.examentecnico.presenter.CoursePresenter

class CourseInteractorImpl(coursePresenter:CoursePresenter) :
    CourseInteractor {
    private val courseRepository = CourseRepositoryImpl(coursePresenter)
    override fun getCourses() {
        courseRepository.getCourses()
    }

    override fun getUserData() {
        courseRepository.getUserData()
    }

    override fun getState() {
        courseRepository.getState()
    }

}