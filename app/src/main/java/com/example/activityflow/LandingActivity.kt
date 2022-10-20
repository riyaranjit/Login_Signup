package com.example.activityflow


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {
 lateinit var signin: Button
 lateinit var signup: Button
 lateinit var myBatteryReceiver: MyBatteryReceiver

 lateinit var batteryView : TextView
 lateinit var progressView: ProgressBar

 @SuppressLint("SetTextI18n")

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_landing)

  batteryView= findViewById<TextView>(R.id.batteryViewId)
  progressView= findViewById(R.id.progressBar)

  signin= findViewById(R.id.signin)
  signup= findViewById(R.id.signup)

  signin.setOnClickListener{
   startLoginActivity()
  }

  signup.setOnClickListener{
   startSignUpActivity()
  }

  myBatteryReceiver= MyBatteryReceiver(progressView,batteryView)
  registerReceiver(myBatteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))


 }

 override fun onDestroy() {
  super.onDestroy()
  unregisterReceiver(myBatteryReceiver)
 }

 private fun startLoginActivity(){
  var intent= Intent(this, LoginActivity::class.java)
  intent.putExtra("mainusername","${LoginActivity.mainusername}")
  startActivity(intent)
  finish()
 }

 private fun startSignUpActivity(){
  var intent= Intent(this, SignUpActivity::class.java)
  startActivity(intent)
  finish()
 }

 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  super.onActivityResult(requestCode, resultCode, data)

  if(requestCode==1001 && resultCode==Activity.RESULT_OK){
   val isLoginTrue= data?.getBooleanExtra("isLoginSuccess",false)
   if(isLoginTrue==true){
    Toast.makeText(applicationContext,""+data?.getBooleanExtra("displayMsg", true), Toast.LENGTH_LONG).show()
   }else{
    Toast.makeText(applicationContext,""+data?.getBooleanExtra("displayMsg", false), Toast.LENGTH_LONG).show()
   }
  }
 }






}