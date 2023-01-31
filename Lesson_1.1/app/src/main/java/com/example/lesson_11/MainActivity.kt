package com.example.lesson_11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitVeiw()
    }
    fun InitVeiw(){
        var button_red: Button = findViewById(R.id.button_red)
        button_red.setOnClickListener{
            OpenRedActivity()
        }
        var button_green: Button = findViewById(R.id.button_green)
        button_green.setOnClickListener{
            OpenGreenActivity()
        }
        var button_blue: Button = findViewById(R.id.button_blue)
        button_blue.setOnClickListener{
            OpenBlueActivity()
        }
    }
    fun OpenRedActivity(){
        var intent: Intent = Intent(this, RedActivity::class.java)
        startActivity(intent)
    }
    fun OpenGreenActivity(){
        var intent: Intent = Intent(this, GreenActivity::class.java)
        startActivity(intent)
    }
    fun OpenBlueActivity(){
        var intent: Intent = Intent(this, BlueActivity::class.java)
        startActivity(intent)
    }
}