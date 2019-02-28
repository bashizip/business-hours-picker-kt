package com.bashizip.bhlib

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

import java.util.Calendar
import java.util.Date
import java.util.LinkedList

class BusinessHoursWeekView : LinearLayout {


    private var model: List<BusinessHours>? = null


    constructor(context: Context) : super(context) {
        initViews(context, null)

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initViews(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs) {}

    private fun initViews(context: Context, attrs: AttributeSet?) {

        orientation = LinearLayout.VERTICAL

        model = LinkedList()

    }

    private fun update() {

        this.removeAllViews()
        invalidate()

        var businessHourView: BusinessHourView? = null

        for (i in model!!.indices) {

            businessHourView = BusinessHourView(this.context)

            businessHourView.setBusinessHours(model!![i])

            val TODAY = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

            if (businessHourView.getBusinessHours().dayIndex == TODAY) {
                businessHourView.seBold(true)
            }

            this.addView(businessHourView, i)
        }

        invalidate()
    }

    internal fun filter() {
        // put the current day on top of the model

        val calendar = Calendar.getInstance()
        calendar.time = Date()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)


    }

    fun setModel(model: List<BusinessHours>?) {

        if (model != null) {
            this.model = model
            update()
        }

    }

}
