package com.bashizip.businesshourspicker

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

import com.bashizip.bhlib.BusinessHours
import com.bashizip.bhlib.BusinessHoursWeekPicker

import java.io.Serializable

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bh_picker = findViewById<BusinessHoursWeekPicker>(R.id.bh_picker)
        val btn_apply = findViewById<Button>(R.id.btn_apply)

        btn_apply.setOnClickListener { view ->

            val bhs = bh_picker.businessHoursList

            val intent = Intent(this, ViewerActivity::class.java)
            intent.putExtra(BH_LIST, bhs as Serializable)
            startActivity(intent)

        }
    }

    companion object {

        val BH_LIST = "bh_list"
    }
}
