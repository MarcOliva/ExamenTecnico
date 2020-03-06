package com.oliva.marc.examentecnico.presenter.Impl

import com.oliva.marc.examentecnico.view.adapter.CourseView
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User
import com.oliva.marc.examentecnico.model.interactor.Impl.CourseInteractorImpl
import com.oliva.marc.examentecnico.presenter.CoursePresenter

class CoursePresenterImpl(val courseView: CourseView)  :
    CoursePresenter {
    private val courseInteractor =
        CourseInteractorImpl(
            this
        )
    override fun getCourses() {
        courseInteractor.getCourses()
    }

    override fun getUserData() {
        courseInteractor.getUserData()
    }


    //views methods
    override fun showCourses(courses: ArrayList<Course>) {
        courseView.showCourses(courses)
    }

    override fun setUserData(user: User) {
        courseView.setUserData(user)
    }


}