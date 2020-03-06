package com.oliva.marc.examentecnico.model.interactor.Impl

import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.interactor.DetailCourseInteractor
import com.oliva.marc.examentecnico.model.repository.DetailCourseRepository
import com.oliva.marc.examentecnico.model.repository.impl.DetailCourseRepositoryImpl
import com.oliva.marc.examentecnico.presenter.DetailCoursePresenter

class DetailCourseInteractorImpl(detailCoursePresenter: DetailCoursePresenter) :DetailCourseInteractor{
    private val detailCourseRepository:DetailCourseRepository = DetailCourseRepositoryImpl(detailCoursePresenter)
    override fun getDetailCourse(course:Course) {
        detailCourseRepository.getDetailCourse(course)
    }

}