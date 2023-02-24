package com.sandeep.foodrunner.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.sandeep.foodrunner.R

class OrderPlacedActivity : AppCompatActivity() {

    private lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_placed)

        btnOk=findViewById(R.id.btnOk)

        btnOk.setOnClickListener {

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finishAffinity()//finish all the activities
        }
    }


    override fun onBackPressed() {

        val intent= Intent(this,DashboardActivity::class.java)
        startActivity(intent)
        finishAffinity()//finish all the activities
    }
}