package com.oliva.marc.examentecnico.model.repository

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.http.GET

interface CourseService {
    @GET
    fun getCourses():Call<List<JsonArray>>
}