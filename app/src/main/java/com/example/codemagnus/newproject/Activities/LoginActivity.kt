package com.example.codemagnus.newproject.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import com.android.volley.VolleyError
import com.example.codemagnus.newproject.R
import com.example.codemagnus.newproject.Session.Session
import com.mycart.advance.https.API
import com.mycart.advance.https.APIRequest
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by codemagnus on 3/19/18.
 */
class LoginActivity:AppCompatActivity() {

    private val TAG2 = "#####################"
    private var session: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        session = Session(this)
        if (session?.isUserLogin()!!){
            startNewActivity()
        }

        btn_login.setOnClickListener {
            if (isFieldValid()){
                startNewActivity()
                //postLogin()
            }
        }

    }

    override fun onBackPressed() {


        val alert = AlertDialog.Builder(this)
        alert.setTitle("Exit Application")
        alert.setMessage("Do you really want to exit?")
        alert.setNegativeButton("No", { _, _ ->
        })
        alert.setPositiveButton("Yes", { _, _ ->
         finish()
        }).show()

    }

    private fun postLogin() {
        val params:MutableMap<String, String> = HashMap()
        params["username"] = et_login_username.text.toString()
        params["password"] = et_login_password.text.toString()
        APIRequest.post(this, API.LOGIN, params, object : APIRequest.URLCallback{
            override fun didUrlResponse(response: String) {
                Session(this@LoginActivity).authorize(response)
                startNewActivity()
            }

            override fun didUrlError(error: VolleyError) {
            }
        })
    }



    private fun isFieldValid(): Boolean{

        if (TextUtils.isEmpty(et_login_storename.text.toString())){
            input_login_storename.error = "Storename is required"
            return false
        }

        input_login_storename.error = null

        if (TextUtils.isEmpty(et_login_username.text.toString())){
            input_login_username.error = "Username is required"
            return false
        }

        input_login_username.error = null

        if (TextUtils.isEmpty(et_login_password.text.toString())){
            input_login_password.error = "Password is required"
            return false
        }

        input_login_password.error = null

        return true
    }

    private fun startNewActivity(){
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

}