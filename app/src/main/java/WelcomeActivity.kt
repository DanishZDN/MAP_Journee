package com.example.journee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.example.mobileapp_journeeg9.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val continueBtn = findViewById<Button>(R.id.continueBtn)
        continueBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
