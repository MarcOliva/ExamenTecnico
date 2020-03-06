package com.oliva.marc.examentecnico.presenter

import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User

interface CoursePresenter {
    fun getCourses()
    fun getUserData()
    fun getState()

    fun showCourses(courses:ArrayList<Course>)
    fun setUserData(user: User)
    fun setState(state: Int?)
}