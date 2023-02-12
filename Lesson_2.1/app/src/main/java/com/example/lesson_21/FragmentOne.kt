package com.example.lesson_21

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class FragmentOne : Fragment() {
    val TAG = FragmentOne::class.java.toString()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tv_message = view.findViewById<TextView>(R.id.tv_message)
        if(arguments?.getString("ID") != null){
            tv_message.setText(arguments?.getString("ID"))
            val bundle = this.arguments
            tv_message.setText(bundle!!.getString("ID"))
        }




        val btn_enter = view.findViewById<Button>(R.id.button_enter)
        btn_enter.setOnClickListener{
            val f: Fragment = FragmentTwo()
            val bundle = Bundle()

            bundle.putString("ID", tv_message.text.toString())
            f.arguments = bundle
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(R.id.fragment, f)
            ft.commit()
        }

    }
}