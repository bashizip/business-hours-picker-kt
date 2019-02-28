package com.bashizip.bhlib

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class BusinessHourView : LinearLayout {


    internal var textView: TextView
    internal var businessHours: BusinessHours
    private var bhText: String? = null
    private var v: View? = null

    constructor(context: Context) : super(context) {
        initViews(context, null)

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initViews(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs) {}


    internal fun initViews(context: Context, attrs: AttributeSet?) {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        v = layoutInflater.inflate(R.layout.business_hours_view, this, true)

        textView = v!!.findViewById(R.id.bh_text)

        val array = context.theme
                .obtainStyledAttributes(attrs, R.styleable.BusinessHoursWeekView, 0, 0)

        try {

            bhText = array.getString(R.styleable.BusinessHoursWeekView_bhText)


        } finally {
            array.recycle()
        }
    }

    fun getBhText(): String? {
        return bhText
    }

    fun setBhText(bhText: String) {
        this.bhText = bhText
        textView.text = bhText
    }

    fun getBusinessHours(): BusinessHours {
        return businessHours
    }

    fun setBusinessHours(businessHours: BusinessHours?) {

        if (businessHours != null) {
            this.businessHours = businessHours

            textView.text = businessHours.toString()
        }
    }

    fun removeIcons() {
        textView.setCompoundDrawables(null, null, null, null)
    }

    fun seBold(b: Boolean) {
        textView.textSize = 18.0f
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.invalidate()
    }
}
