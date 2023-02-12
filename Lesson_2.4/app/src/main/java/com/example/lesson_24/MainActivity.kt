package com.example.lesson_24

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_24.adapter.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    val array = ArrayList<String>()
    var recyclerView_activity: RecyclerView? = null
    val TAG = MainActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitVeiw()
    }
    fun InitVeiw() {
        val contex: Context = this
        recyclerView_activity = findViewById(R.id.recyclerView_activity)
        recyclerView_activity!!.setLayoutManager(GridLayoutManager(contex,1))

        array.add("onCreate")
        Log.d(TAG, "Activity: onCreate")
        refreshAdapter(array)
    }
    fun refreshAdapter(arr: ArrayList<String>) {
        val adaptor = RecyclerAdapter(this, arr)
        recyclerView_activity!!.adapter = adaptor
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        array.add("onAttachFragment")
        Log.d(TAG, "Activity: onAttachFragment")
        //refreshAdapter(array)
    }
    override fun onStart() {
        super.onStart()
        array.add("onStart")
        Log.d(TAG, "Activity: onStart")
        refreshAdapter(array)
    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        array.add("onPostCreate")
        Log.d(TAG, "Activity: onPostCreate")
        refreshAdapter(array)
    }

    override fun onResume() {
        super.onResume()
        array.add("onResume")
        Log.d(TAG, "Activity: onResume")
        refreshAdapter(array)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        array.add("onResumeFragments")
        Log.d(TAG, "Activity: onResumeFragments")
        refreshAdapter(array)
    }

    override fun onPostResume() {
        super.onPostResume()
        array.add("onPostResume")
        Log.d(TAG, "Activity: onPostResume")
        refreshAdapter(array)
    }

    override fun onPause() {
        super.onPause()
        array.add("onPause")
        Log.d(TAG, "Activity: onPause")
        refreshAdapter(array)
    }

    override fun onStop() {
        super.onStop()
        array.add("onStop")
        Log.d(TAG, "Activity: onStop")
        refreshAdapter(array)
    }

    override fun onRestart() {
        super.onRestart()
        array.add("onRestart")
        Log.d(TAG, "Activity: onRestart")
        refreshAdapter(array)
    }

    override fun onDestroy() {
        super.onDestroy()
        array.add("onDestroy")
        Log.d(TAG, "Activity: onDestroy")
        refreshAdapter(array)
    }
}