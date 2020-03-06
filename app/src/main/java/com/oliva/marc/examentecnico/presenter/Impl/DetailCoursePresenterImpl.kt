package com.oliva.marc.examentecnico.presenter.Impl

import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.interactor.DetailCourseInteractor
import com.oliva.marc.examentecnico.model.interactor.Impl.DetailCourseInteractorImpl
import com.oliva.marc.examentecnico.presenter.DetailCoursePresenter
import com.oliva.marc.examentecnico.view.adapter.DetailCourseView

class DetailCoursePresenterImpl(val detailCourseView: DetailCourseView) :DetailCoursePresenter{
    private val interactorDetailCourse = DetailCourseInteractorImpl(this)
    override fun getDetailCourse(course: Course) {
        interactorDetailCourse.getDetailCourse(course)
    }

    override fun setUpCourse(course: Course) {
        detailCourseView.setUpCourse(course)
    }

}