package com.example.activityflow

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var mainusername: EditText
    lateinit var mainemail:EditText
    lateinit var mainpassword: EditText
    lateinit var submit: Button


    lateinit  var sharedPref: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mainusername=findViewById(R.id.mainusername)
        mainemail= findViewById(R.id.mainemail)
        mainpassword= findViewById(R.id.mainpassword)
        submit= findViewById((R.id.submit))

        sharedPref = SharedPref(applicationContext)


        submit.setOnClickListener{
            val  username: String= mainusername.text.toString()
            val email: String= mainemail.text.toString()
            val password: String= mainpassword.text.toString()
//            val editor: SharedPreferences.Editor= sharedPref.edit()

//            editor.putString("username",username)
//            editor.putString("email",email)
//            editor.putString("address",address)
//            editor.apply()


            if(username.equals("")|| email.equals("")|| password.equals("")){
                Toast.makeText(this,"Please Enter Details.",Toast.LENGTH_SHORT).show()
            }else{
                sharedPref.save_String("username",username)
                sharedPref.save_String("email",email)
                sharedPref.save_String("password",password)

                Toast.makeText(this,"Data Saved Successfully.",Toast.LENGTH_SHORT).show()

            }
//            Log.e("TAG",""+ sharedPref.getString("username","defaultname"))
//            Log.e("TAG",""+ sharedPref.getString("email","defaultemail"))
//            Log.e("TAG",""+ sharedPref.getString("address","defaultaddress"))

            startSignUpActivity()
        }


    }

    private fun startSignUpActivity(){
//
//        val sharedUsername= sharedPref.getString("username", "default name")
//        val sharedEmail= sharedPref.getString("email", "default email")
//        val sharedAddress= sharedPref.getString("address","default address")


//        val signUpModel= SignUpModel()
//        signUpModel.username= sharedUsername.toString()
//        signUpModel.email= sharedEmail.toString()
//        signUpModel.address= sharedAddress.toString()

//        val signUpModel= SignUpModel()
//        signUpModel.username= mainusername.text.toString()
//        signUpModel.email= mainemail.text.toString()
//        signUpModel.address= mainaddress.text.toString()

        val intent= Intent(this, LoginActivity::class.java)
//        intent.putExtra(DashboardActivity.SIGN_UP_MODEL, signUpModel)
        startActivity(intent)
        finish()

    }




}