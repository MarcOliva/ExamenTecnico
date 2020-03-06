package com.oliva.marc.examentecnico.model.repository

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface CourseService {
    @GET("5e52d5832d00006300357bdb?user_id=465")
    fun getCourses(@Header("Authorization") token: String): Call<List<JsonObject>>

    @GET("5e52d4a52d00008200357bda?user_id=465")
    fun getUserData(@Header("Authorization") token: String): Call<JsonObject>
    @GET("5e52d42b2d0000261d357bd9?user_id=465")
    fun getState(@Header("Authorization") token: String):Call<JsonObject>
}