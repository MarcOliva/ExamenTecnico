package com.oliva.marc.examentecnico.model

import com.google.gson.JsonObject
import java.io.Serializable


class Course(course: JsonObject) : Serializable {
    var name = ""
    var code = ""

    init {
        name = course.get(NAME).asString
        code = course.get(CODE).asString
    }


    companion object {
        private val NAME = "name"
        private val CODE = "code"
    }
}