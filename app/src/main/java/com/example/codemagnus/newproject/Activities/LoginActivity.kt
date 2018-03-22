package com.example.codemagnus.newproject.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.codemagnus.newproject.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by codemagnus on 3/19/18.
 */
class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener{

            val loginintent = Intent(this, MainActivity::class.java)
            startActivity(loginintent)
        }

    }
}