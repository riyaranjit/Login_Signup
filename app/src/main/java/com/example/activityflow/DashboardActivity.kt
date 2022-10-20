package com.example.activityflow

import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class DashboardActivity : AppCompatActivity() {

    lateinit var username: TextView
    lateinit var email: TextView
    lateinit var address: TextView
    lateinit var sharedPref: SharedPreferences
    lateinit var btnShowAlert: Button

    companion object {
        const val SIGN_UP_MODEL = "signUpModel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        username= findViewById(R.id.usernamevalue)
        email= findViewById(R.id.emailvalue)
        address= findViewById(R.id.addressvalue)
        btnShowAlert= findViewById(R.id.btnShowAlert)

        btnShowAlert.setOnClickListener {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to close this application ?")
                // if the dialog is cancelable
                .setCancelable(true)
                // positive button text and action
                .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id ->
                    run {
                        SharedPref(this ).clearSharedPreference()
                        finish()
                    }
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("AlertDialogExample")
            // show alert dialog
            alert.show()
        }

//        val data = intent
//        val signUpModel = data.getSerializableExtra(SIGN_UP_MODEL) as SignUpModel
//        username.setText(  signUpModel.username)
//        email.setText(  signUpModel.email)
//        address.setText(  signUpModel.address)






    }

}