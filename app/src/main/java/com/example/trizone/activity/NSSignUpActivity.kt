package com.example.trizone.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.trizone.NSApplication
import com.example.trizone.R
import com.example.trizone.database.NSDatabase
import com.example.trizone.database.User

/*Created by Maneesha on 19/12/2021*/

class NSSignUpActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var registerButton: Button

    private lateinit var userName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var phoneNumber: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        initView()
        getData()
        registerButton.setOnClickListener {
            saveData()
        }

    }
    /*Function to initialize view components*/

    private fun initView() {

        usernameEditText = findViewById(R.id.userNameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        emailEditText = findViewById(R.id.emailEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        registerButton = findViewById(R.id.registerButton)
    }

    /*Function to get data entered by the user*/
    private fun getData() {
        userName = usernameEditText.text.toString()
        email = emailEditText.text.toString()
        password = passwordEditText.text.toString()
        phoneNumber = phoneNumberEditText.text.toString()
    }

    /*Function to save user data to database*/
    private fun saveData() {
        val user = User(
            userName = userName,
            uid = 1,
            email = email,
            password = password,
            phoneNumber = phoneNumber
        )
        /*    val db = Room.databaseBuilder(
                applicationContext,
                NSDatabase::class.java, "nsroom"
            ).build()*/

        val application = NSApplication.getApp()

        val db: NSDatabase? = NSApplication.database
        db?.userDao()?.insertAll(user)
        Log.e("user", "" + userName + email + password + phoneNumber)
    }
}