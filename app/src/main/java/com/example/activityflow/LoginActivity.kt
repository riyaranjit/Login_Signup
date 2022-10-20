package com.example.activityflow


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.*
import android.text.Editable;
import android.util.Log
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var username: TextInputLayout
    lateinit var password: TextInputLayout

    companion object{
        public  var mainusername: EditText? = null
    }
    lateinit var mainpassword: EditText

    lateinit var siginbutton: Button
    lateinit var google: ImageButton
    lateinit var apple: ImageButton
    lateinit var facebook: ImageButton
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var text3: TextView
    lateinit var text4: TextView
    lateinit var recover: TextView
    lateinit var continuewith: TextView
    private lateinit var sw: SwitchMaterial

    lateinit var sharedPref: SharedPref

//    private val textWatcher:TextWatcher= object : TextWatcher{
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//            val emailInput=  username.text.toString()
//            val passwordInput=  password.text.toString()
//
//            if(emailInput.length>0 && emailInput.matches(emailPattern.toRegex())){
//
//                Toast.makeText(getApplicationContext(),"Valid email address",Toast.LENGTH_SHORT).show();
//
//            }else{
//                username.setError(" Invalid email ")
//            }
//
//
//            siginbutton.setEnabled(!emailInput.isEmpty() && !passwordInput.isEmpty())
//        }
//        override fun afterTextChanged(s: Editable) {}
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username=findViewById(R.id.textField)
        password= findViewById(R.id.password)
        siginbutton= findViewById(R.id.signin)
        text1= findViewById(R.id.text1)
        text2= findViewById(R.id.text2)
        text3= findViewById(R.id.text3)
        text4= findViewById(R.id.text4)
        recover= findViewById(R.id.recover)
        continuewith= findViewById(R.id.continuewith)
        sw= findViewById(R.id.switch1)

        sharedPref = SharedPref(applicationContext)



        val google= findViewById<ImageButton>(R.id.googleicon)
        google.setOnClickListener(){
            val url= ""
            val i= Intent(Intent.ACTION_VIEW)
            i.data= Uri.parse(url)
            startActivity(i)
        }
        apple= findViewById(R.id.appleicon)
        facebook= findViewById(R.id.fbicon)



        sw.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                var language: String = ""
                if (isChecked) {
                    language = "ne"
                    var context = updateResources(language)
                    text1.text = context.getString(R.string.text1)
                    text2.text = context.getString(R.string.hyperlink)
                    text3.text = context.getString(R.string.text3)
                    text4.text = context.getString(R.string.text4)
                    username?.hint =context.getString(R.string.mainusername)
                    password.hint=context.getString(R.string.passwordfield)
                    recover.text= context.getString(R.string.recover)
                    siginbutton.text= context.getString(R.string.signin)
                    continuewith.text= context.getString(R.string.continuewith)


                } else {
                    language = "en"
                    var context  = updateResources(language)
                    text1.text = context.getString(R.string.text1)
                    text2.text = context.getString(R.string.hyperlink)
                    text3.text = context.getString(R.string.text3)
                    text4.text = context.getString(R.string.text4)
                    username?.hint=context.getString(R.string.mainusername)
                    password.hint=context.getString(R.string.passwordfield)
                    recover.text= context.getString(R.string.recover)
                    siginbutton.text= context.getString(R.string.signin)
                    continuewith.text= context.getString(R.string.continuewith)
                }}})

        mainusername= findViewById(R.id.mainusername)
        mainpassword= findViewById(R.id.passwordfield)


        val login_status=sharedPref!!.getPreferenceString("login_status")
        if(login_status!=null){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }


    siginbutton.setOnClickListener {
        val msg: String = mainusername?.text.toString()
        val pas: String = mainpassword.text.toString()

//        val editor: SharedPreferences.Editor=sharedPref.edit()
//
//        editor.putString("username", msg)
//        editor.putString("password", pas)
//        editor.apply()
//
//        Log.e("TAG",""+ sharedPref.getString("username","defaultname"))
//        Log.e("TAG",""+ sharedPref.getString("password","defaultpassword"))


        if (msg.trim().isEmpty()) {
            username.error = "Required"
        } else if (pas.trim().isEmpty()) {
            password.error = "Required"
        } else {

            val username_id= sharedPref!!.getPreferenceString("username")
            val password_id= sharedPref!!.getPreferenceString("password")

            if(username_id!!.equals(msg)&& password_id!!.equals(pas)){


                sharedPref.save_String("login_status","1")
                val data=intent
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()

            }

//            val data = intent
//            val stringFromIntent = data.getStringExtra("mainusername").addEmptyValueIfNull()
//            mainusername?.setText(stringFromIntent)
//
//            val intent= Intent()
////            intent.putExtra("mainusername", "${LoginActivity.mainusername}")
//            setResult(Activity.RESULT_OK, intent)
//            if(stringFromIntent.equals(data.getStringExtra("mainusername").addEmptyValueIfNull(), true)){
//                intent.putExtra("isLoginSuccess", true)
//                intent.putExtra("displayMsg", msg)
//
//            }else{
//                intent.putExtra("isLoginSuccess", false)
//                intent.putExtra("displayMsg", msg)
//            }
//            finish()
            Toast.makeText(applicationContext, "Login Successful ", Toast.LENGTH_SHORT).show()
        }

    }

        mainusername?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(mainusername?.text.toString())
                        .matches()
                )
                    siginbutton.isEnabled = true
                else {
                    siginbutton.isEnabled = false
                    mainusername?.setError("Invalid Email")
                }
            }
        })

    }



    private fun updateResources(language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration: Configuration = this.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return this.createConfigurationContext(configuration)
    }


//    private fun restartActivity() {
//        val intent = intent
//        finish()
//        startActivity(intent)
//    }

}


