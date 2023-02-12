package com.example.lesson_21

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val et_message = view.findViewById<EditText>(R.id.et_message)
        et_message.setText(requireArguments().getString("ID"))
        val bundle = this.arguments
        et_message.setText(bundle!!.getString("ID"))

        val btn_save = view.findViewById<Button>(R.id.button_save)
        btn_save.setOnClickListener{
            val f: Fragment = FragmentOne()
            val bundle = Bundle()
            bundle.putString("ID", et_message.text.toString())
            f.arguments = bundle
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(R.id.fragment, f)
            ft.commit()
        }
    }

}