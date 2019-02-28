package com.bashizip.bhlib


class BusinessHours : BasePojo, Comparable<BusinessHours> {
    var dayIndex: Int = 0
    var dayOfWeek: String? = null
    var from: String? = null
    var to: String? = null

    constructor() {


    }


    constructor(dayOfWeek: String, from: String, to: String) {
        this.dayOfWeek = dayOfWeek
        this.from = from
        this.to = to
    }


    override fun toString(): String {
        return "$dayOfWeek, $from - $to"
    }

    override fun compareTo(businessHours: BusinessHours): Int {
        return 0
    }

    companion object {

        internal var week_days_int = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    }
}
