package com.example.lesson_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.lesson_22.R
import com.example.lesson_22.Fragment_1
import com.example.lesson_22.Fragment_2
import com.example.lesson_22.Fragment_3

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnA = findViewById<Button>(R.id.first_a)
        val btnB = findViewById<Button>(R.id.second_b)
        val btnC = findViewById<Button>(R.id.third_c)

        val btn1 = findViewById<Button>(R.id.first)
        val btn2 = findViewById<Button>(R.id.second)
        val btn3 = findViewById<Button>(R.id.third)

        btnA.setOnClickListener{ onClickA() }
        btnB.setOnClickListener{ onClickB() }
        btnC.setOnClickListener{ onClickC() }

        btn1.setOnClickListener{ onClick1() }
        btn2.setOnClickListener{ onClick2() }
        btn3.setOnClickListener{ onClick3() }
    }
    fun onClick1(){
        val f1 = Fragment_1()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_number, f1)
        ft.commit()
    }
    fun onClick2(){
        val f2 = Fragment_2()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_number, f2)
        ft.commit()
    }
    fun onClick3(){
        val f3 = Fragment_3()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_number, f3)
        ft.commit()
    }

    fun onClickA(){
        val f1 = Fragment_a()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_letter, f1)
        ft.commit()
    }
    fun onClickB(){
        val f2 = Fragment_b()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_letter, f2)
        ft.commit()
    }
    fun onClickC(){
        val f3 = Fragment_c()
        val ft:FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container_letter, f3)
        ft.commit()
    }
}