package com.example.lesson_13

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelloActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        InitView()
    }
    fun InitView(){
        val tv_hello:TextView = findViewById(R.id.tv_hello)
        val name = intent.getStringExtra("name")
        tv_hello.setText("Hello, {"+name+"}!")
    }
}