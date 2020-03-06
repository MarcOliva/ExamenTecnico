package com.oliva.marc.examentecnico.model.repository.impl

import com.google.gson.JsonObject
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User
import com.oliva.marc.examentecnico.model.repository.CourseRepository
import com.oliva.marc.examentecnico.model.repository.ReferenceCourseService
import com.oliva.marc.examentecnico.model.repository.Utils
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseRepositoryImpl(val coursePresenter: CoursePresenter) :
    CourseRepository {



    override fun getCourses() {
        val apiAdapter =
            ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        val courses = ArrayList<Course>()
        apiService.getCourses(Utils.getToken()).enqueue(object : Callback<List<JsonObject>> {
            override fun onFailure(call: Call<List<JsonObject>>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(
                call: Call<List<JsonObject>>,
                response: Response<List<JsonObject>>
            ) {

                val courseArray = response.body()?.toMutableList()
                if (courseArray != null) {
                    for (e in courseArray) {
                        val course =
                            Course(e.asJsonObject)
                        courses.add(course)
                    }
                }
                coursePresenter.showCourses(courses)
            }

        })



    }

    override fun getUserData() {
        val apiAdapter =
            ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        apiService.getUserData(Utils.getToken()).enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val user = response.body()
                coursePresenter.setUserData(
                    User(
                        user?.asJsonObject
                    )
                )
            }

        })

    }

}