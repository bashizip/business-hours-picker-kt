package com.bashizip.bhlib

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

import java.util.LinkedList

class BusinessHoursWeekPicker : LinearLayout {

    internal var businessHoursPickerList: MutableList<BusinessHoursPicker>


    private var businessHoursList: MutableList<BusinessHours>? = null

    constructor(context: Context) : super(context) {
        initViews(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initViews(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs) {}

    private fun initViews(context: Context, attrs: AttributeSet?) {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.business_hours_week_picker, this, true)

        businessHoursPickerList = LinkedList()

        this.orientation = LinearLayout.VERTICAL

        val monday = BusinessHoursPicker(this.context)
        monday.dayOfWeek = context.getString(R.string.bhv_monday)
        businessHoursPickerList.add(monday)
        this.addView(monday, 1)

        val tuesday = BusinessHoursPicker(this.context)
        tuesday.dayOfWeek = context.getString(R.string.bhv_tuesday)
        businessHoursPickerList.add(tuesday)
        this.addView(tuesday, 2)

        val wednesday = BusinessHoursPicker(this.context)
        wednesday.dayOfWeek = context.getString(R.string.bhv_wednesday)
        businessHoursPickerList.add(wednesday)
        this.addView(wednesday, 3)

        val thursday = BusinessHoursPicker(this.context)
        thursday.dayOfWeek = context.getString(R.string.bhv_thursday)
        businessHoursPickerList.add(thursday)
        this.addView(thursday, 4)

        val friday = BusinessHoursPicker(this.context)
        friday.dayOfWeek = context.getString(R.string.bhv_friday)
        businessHoursPickerList.add(friday)
        this.addView(friday, 5)

        val saturday = BusinessHoursPicker(this.context)
        saturday.dayOfWeek = context.getString(R.string.bhv_saturday)
        businessHoursPickerList.add(saturday)
        this.addView(saturday, 6)

        val sunday = BusinessHoursPicker(this.context)
        sunday.dayOfWeek = context.getString(R.string.bhv_sunday)
        businessHoursPickerList.add(sunday)
        this.addView(sunday, 7)


    }

    fun getBusinessHoursList(): List<BusinessHours> {

        businessHoursList = LinkedList()

        for (view in businessHoursPickerList) {
            if (view.isOpenDay) {
                businessHoursList!!.add(view.businessHours)
            }
        }

        return businessHoursList
    }


}
