package com.oliva.marc.examentecnico.model.Entity

import com.google.gson.JsonObject
import java.io.Serializable


class Course(course: JsonObject?) : Serializable {
    var name :String ? =null
    var code :String ? =null
    var description:String ? =null

    init {
        name = course?.get(NAME)?.asString
        code = course?.get(CODE)?.asString
        if (course?.get(DESCRIPTION)!=null){
            description = course.get(DESCRIPTION).asString
        }

    }


    companion object {
        private val NAME = "curso"
        private val CODE = "código"
        private val DESCRIPTION ="detalle"
    }
}