package com.example.material_design.ui.sign_in

import android.graphics.Insets.add
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.material_design.R
import com.example.material_design.databinding.FragmentSignInBinding
import com.example.material_design.ui.catalog.CatalogFragment

class SignInFragment:Fragment() {
    private lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonSignIn.setOnClickListener {
            parentFragmentManager.commit {
                add<CatalogFragment>(R.id.container)
                addToBackStack(null)
            }
        }
        binding.textPassword.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                parentFragmentManager.commit {
                    replace<CatalogFragment>(R.id.container)
                    addToBackStack(null)
                }
                true
            } else {
                false
            }
        }
    }
    private fun navigateToCatalog() {
        parentFragmentManager.commit {
            add<CatalogFragment>(R.id.container)
            addToBackStack(null)
        }
    }


}