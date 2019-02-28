package com.bashizip.bhlib

import java.io.Serializable
import java.util.Objects

abstract class BasePojo : Serializable {
    var id: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is BasePojo) return false
        val basePojo = o as BasePojo?
        return id == basePojo!!.id
    }

    override fun hashCode(): Int {

        return Objects.hash(id)
    }


}
