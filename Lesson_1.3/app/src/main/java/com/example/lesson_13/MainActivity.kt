package com.example.lesson_13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitView()
    }
    fun InitView(){
        val button_onclick: Button = findViewById(R.id.button_onclick)
        val edittext_name = findViewById<EditText>(R.id.edittext_name)
        button_onclick.setOnClickListener{
            val name = edittext_name.text.toString()
            if(name == ""){
                val tv_empty:TextView = findViewById(R.id.tv_empty)
                tv_empty.setText("must not be empty")
            }else{
                OpenHelloActivity(name)
            }
        }
    }
    fun OpenHelloActivity(name: String ){
        var intent: Intent = Intent(this, HelloActivity::class.java)
        intent.putExtra("name",name)
        startActivity(intent)
    }
}