package com.oliva.marc.examentecnico.model.repository

import com.google.gson.JsonObject
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.Entity.User
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseRepositoryImpl(val coursePresenter: CoursePresenter) : CourseRepository {

    companion object {
        private const val token =
            "bearer  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vZGVhbGJyYW5kLWFwaS5kZXYtZm9yY2VjbG9zZS5jb20vbW9iaWxlL3YyL2F1dGgvbG9naW4iLCJpYXQiOjE1ODIxNjgyOTIsImV4cCI6MTU4Mjc3MzA5MiwibmJmIjoxNTgyMTY4MjkyLCJqdGkiOiJMZHg2WTVadjNXWGI0YUEzIiwic3ViIjo2NDUsInBydiI6IjdhM2MxNWY4MmMwMWJjNTExOTZhODc2NTk1YTNjNjBmOTFlZGNlY2IifQ.wPeaTzC3U6zoVPi_yqUAkJmEa4ZThI0i6-D9hV1VZ5Q"
    }

    override fun getCourses() {
        val apiAdapter = ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        val courses = ArrayList<Course>()
        apiService.getCourses(token).enqueue(object : Callback<List<JsonObject>> {
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
        val apiAdapter = ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        apiService.getUserData(token).enqueue(object : Callback<JsonObject> {
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

    override fun getState() {
        val apiAdapter = ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        apiService.getState(token).enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val state = response.body()
                val value = state?.getAsJsonPrimitive("estado")?.asInt
                coursePresenter.setState(value)
            }

        })

    }

}