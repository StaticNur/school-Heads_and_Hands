package com.example.lesson_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.first)
        val btn2 = findViewById<Button>(R.id.second)
        val btn3 = findViewById<Button>(R.id.third)

        btn1.setOnClickListener { onClick1() }
        btn2.setOnClickListener { onClick2() }
        btn3.setOnClickListener { onClick3() }
    }
    fun onClick1() {
        val f1 = Fragment_1()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, f1)
            //.addToBackStack("MyStack")
            .commit()
    }
    fun onClick2() {
        val f2 = Fragment_2()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, f2)
            //.addToBackStack("MyStack")
            .commit()
    }
    fun onClick3() {
        val f3 = Fragment_3()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, f3)
            //.addToBackStack("MyStack")
            .commit()
    }
}