package com.oliva.marc.examentecnico.model.repository.impl

import com.google.gson.JsonObject
import com.oliva.marc.examentecnico.model.Entity.Course
import com.oliva.marc.examentecnico.model.repository.DetailCourseRepository
import com.oliva.marc.examentecnico.model.repository.ReferenceCourseService
import com.oliva.marc.examentecnico.model.repository.Utils
import com.oliva.marc.examentecnico.presenter.DetailCoursePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCourseRepositoryImpl (val detailCoursePresenter: DetailCoursePresenter):DetailCourseRepository{
    override fun getDetailCourse(course: Course) {
        val apiAdapter =
            ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        apiService.getDataCourse(Utils.getToken(),course.code).enqueue(object :
            Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                detailCoursePresenter.setUpCourse(Course(response.body()?.asJsonObject))
            }

        })
    }

}