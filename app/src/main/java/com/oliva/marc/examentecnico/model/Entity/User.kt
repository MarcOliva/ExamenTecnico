package com.oliva.marc.examentecnico.model.Entity

import com.google.gson.JsonObject

class User(user: JsonObject?){
    var name = ""
    var code = ""
    var others= ""

    init {
        name = user?.get(NAME)!!.asString
        code = user.get(CODE).asString
        others  = user.get(OTHERS).asString
    }


    companion object {
        private val NAME = "nombre"
        private val CODE = "codigo"
        private val OTHERS = "otros"

    }
}