package com.oliva.marc.examentecnico.model.repository

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.model.interactor.CourseInteractorImpl
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CourseRepositoryImpl(val coursePresenter : CoursePresenter):CourseRepository {

    companion object{
        private const val URL = "http://www.mocky.io/v2/"
        private const val token = "bearer  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vZGVhbGJyYW5kLWFwaS5kZXYtZm9yY2VjbG9zZS5jb20vbW9iaWxlL3YyL2F1dGgvbG9naW4iLCJpYXQiOjE1ODIxNjgyOTIsImV4cCI6MTU4Mjc3MzA5MiwibmJmIjoxNTgyMTY4MjkyLCJqdGkiOiJMZHg2WTVadjNXWGI0YUEzIiwic3ViIjo2NDUsInBydiI6IjdhM2MxNWY4MmMwMWJjNTExOTZhODc2NTk1YTNjNjBmOTFlZGNlY2IifQ.wPeaTzC3U6zoVPi_yqUAkJmEa4ZThI0i6-D9hV1VZ5Q"
    }

    override fun getCourses(){
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CourseService::class.java)
        val courses = ArrayList<Course>()
        service.getCourses(token).enqueue(object: Callback<List<JsonObject>> {
            override fun onFailure(call: Call<List<JsonObject>>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(
                call: Call<List<JsonObject>>,
                response: Response<List<JsonObject>>
            ) {

                val courseArray = response.body()?.toMutableList()
                if (courseArray != null) {
                    for (e in courseArray){
                        val course = Course(e.asJsonObject)
                        courses.add(course)
                    }
                }
                }

        })
        coursePresenter.showCourses(courses)


    }

}