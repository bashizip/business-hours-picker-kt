package com.bashizip.businesshourspicker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.bashizip.bhlib.BusinessHours
import com.bashizip.bhlib.BusinessHoursWeekView

class ViewerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewer)

        val businessHoursWeekView = findViewById<BusinessHoursWeekView>(R.id.bh_view)

        val intent = intent
        val businessHoursList = intent.getSerializableExtra(MainActivity.BH_LIST) as List<BusinessHours>

        businessHoursWeekView.setModel(businessHoursList)
    }
}
