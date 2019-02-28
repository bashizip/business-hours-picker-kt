package com.bashizip.bhlib

import android.content.Context
import android.content.res.TypedArray
import android.support.v7.widget.AppCompatSpinner
import android.support.v7.widget.SwitchCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView


class BusinessHoursPicker : LinearLayout {


    internal var tv_dayOfWeek: TextView
    internal var switch_open: SwitchCompat

    internal var spin_bh_from: AppCompatSpinner
    internal var spin_bh_to: AppCompatSpinner

    internal var lyt_hours: View

    private var dayOfWeek: String? = null
    private var isOpenDay: Boolean = false

    var from: String? = null
    var to: String? = null
    private var v: View? = null

    private var businessHours: BusinessHours? = null


    constructor(context: Context) : super(context) {
        initViews(context, null)
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initViews(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initViews(context, attrs)
    }

    private fun initViews(context: Context, attrs: AttributeSet?) {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = layoutInflater.inflate(R.layout.business_hours_picker, this, true)

        tv_dayOfWeek = v!!.findViewById(R.id.tv_bh_dayofweek)
        switch_open = v!!.findViewById(R.id.switch_open)
        spin_bh_from = v!!.findViewById(R.id.spin_bh_from)
        spin_bh_to = v!!.findViewById(R.id.spin_bh_to)
        lyt_hours = v!!.findViewById(R.id.lyt_hours)


        val array = context.theme
                .obtainStyledAttributes(attrs, R.styleable.BusinessHoursPicker, 0, 0)

        try {

            dayOfWeek = array.getString(R.styleable.BusinessHoursPicker_dayOfWeek)
            isOpenDay = array.getBoolean(R.styleable.BusinessHoursPicker_isOpenDay, false)


        } finally {
            array.recycle()
        }


        setupActions(dayOfWeek)
    }

    fun setupActions(day: String?) {

        tv_dayOfWeek.text = day

        switch_open.setOnCheckedChangeListener { compoundButton, checked ->
            setOpenDay(checked)

            if (checked) {
                lyt_hours.visibility = View.VISIBLE
            } else {
                lyt_hours.visibility = View.GONE
                from = ""
                to = ""
                spin_bh_from.setSelection(0)
                spin_bh_to.setSelection(0)
            }


        }

        spin_bh_from.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {

                from = adapterView.getItemAtPosition(position).toString()

                val allDay = this@BusinessHoursPicker.context.getString(R.string.all_day)

                if (from == allDay) {
                    spin_bh_to.visibility = View.INVISIBLE
                    to = allDay
                } else {
                    spin_bh_to.visibility = View.VISIBLE
                }

            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }


        spin_bh_to.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {

                to = adapterView.getItemAtPosition(position).toString()

                val allDay = this@BusinessHoursPicker.context.getString(R.string.all_day)

                if (to == allDay) {
                    spin_bh_from.visibility = View.INVISIBLE
                    from = allDay
                } else {
                    spin_bh_from.visibility = View.VISIBLE
                }


            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {

            }
        }


        businessHours = BusinessHours(dayOfWeek, from, to)

        switch_open.isChecked = false
        lyt_hours.visibility = View.GONE

    }


    fun isOpenDay(): Boolean {
        return isOpenDay
    }

    fun setOpenDay(openDay: Boolean) {
        isOpenDay = openDay
        switch_open.isChecked = isOpenDay
    }

    fun getDayOfWeek(): String? {
        return dayOfWeek
    }

    fun setDayOfWeek(dayOfWeek: String) {
        this.dayOfWeek = dayOfWeek
        tv_dayOfWeek.text = dayOfWeek
    }

    fun getBusinessHours(): BusinessHours {

        businessHours!!.dayOfWeek = dayOfWeek
        businessHours!!.from = from
        businessHours!!.to = to


        if (dayOfWeek == context.getString(R.string.bhv_sunday)) {
            businessHours!!.dayIndex = 1
        }

        if (dayOfWeek == context.getString(R.string.bhv_monday)) {
            businessHours!!.dayIndex = 2
        }

        if (dayOfWeek == context.getString(R.string.bhv_tuesday)) {
            businessHours!!.dayIndex = 3
        }
        if (dayOfWeek == context.getString(R.string.bhv_wednesday)) {
            businessHours!!.dayIndex = 4
        }

        if (dayOfWeek == context.getString(R.string.bhv_thursday)) {
            businessHours!!.dayIndex = 5
        }

        if (dayOfWeek == context.getString(R.string.bhv_friday)) {
            businessHours!!.dayIndex = 6
        }
        if (dayOfWeek == context.getString(R.string.bhv_saturday)) {
            businessHours!!.dayIndex = 7
        }


        return businessHours
    }
}
