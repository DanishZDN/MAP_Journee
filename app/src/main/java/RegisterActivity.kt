package com.example.journee

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.example.mobileapp_journeeg9.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun goToLogin(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
