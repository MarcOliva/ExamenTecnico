package com.oliva.marc.examentecnico.model.repository

import com.oliva.marc.examentecnico.model.Entity.Course

interface DetailCourseRepository {
    fun getDetailCourse(course:Course)
}