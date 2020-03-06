package com.oliva.marc.examentecnico.view.adapter

import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User

interface CourseView {
    fun showCourses(courses:ArrayList<Course>)
    fun setUserData(user: User)


    fun getUserData()
    fun getCourses()

}