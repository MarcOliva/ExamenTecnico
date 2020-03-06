package com.oliva.marc.examentecnico.model.repository.impl

import com.google.gson.JsonObject
import com.oliva.marc.examentecnico.model.repository.ReferenceCourseService
import com.oliva.marc.examentecnico.model.repository.StateRepository
import com.oliva.marc.examentecnico.model.repository.Utils
import com.oliva.marc.examentecnico.presenter.StatePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateRepositoryImpl (val statePresenter: StatePresenter): StateRepository{
    override fun getState() {
        val apiAdapter =
            ReferenceCourseService()
        val apiService = apiAdapter.getClientService()
        apiService.getState(Utils.getToken()).enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val state = response.body()
                val value = state?.getAsJsonPrimitive("estado")?.asInt
                statePresenter.setState(value)
            }

        })
    }

}