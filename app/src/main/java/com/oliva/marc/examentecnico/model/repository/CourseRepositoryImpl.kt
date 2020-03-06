package com.oliva.marc.examentecnico.model.repository

import com.google.gson.JsonArray
import com.oliva.marc.examentecnico.model.Course
import com.oliva.marc.examentecnico.model.interactor.CourseInteractorImpl
import com.oliva.marc.examentecnico.presenter.CoursePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CourseRepositoryImpl(val coursePresenter : CoursePresenter) {
    private val interactor = CourseInteractorImpl()
    companion object{
        private const val URL = "http://www.mocky.io/v2/5e52d5832d00006300357bdb?user_id=465"
    }

    fun getCourses(){
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CourseService::class.java)
        val courses = ArrayList<Course>()
        service.getCourses().enqueue(object: Callback<List<JsonArray>> {
            override fun onFailure(call: Call<List<JsonArray>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<JsonArray>>,
                response: Response<List<JsonArray>>
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