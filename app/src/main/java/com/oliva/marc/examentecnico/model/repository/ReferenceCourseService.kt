package com.oliva.marc.examentecnico.model.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReferenceCourseService {
    val urlApi = "http://www.mocky.io/v2/"

    fun getClientService():CourseService{
        var retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CourseService::class.java)
    }
}