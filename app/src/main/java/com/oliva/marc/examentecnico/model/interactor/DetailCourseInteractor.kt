package com.oliva.marc.examentecnico.model.interactor

import com.oliva.marc.examentecnico.model.Entity.Course

interface DetailCourseInteractor {
    fun getDetailCourse(course: Course)
}