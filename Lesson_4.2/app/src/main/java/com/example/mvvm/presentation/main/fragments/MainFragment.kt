package com.example.mvvm.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentMainBinding
import com.example.mvvm.presentation.main.adapters.AuthorAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by viewModels()

    lateinit var adapter: AuthorAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRefreshData.setOnClickListener {
            if(viewModel.uiState.value != BookListUiState.Loading())
                viewModel.loadData()
        }

        adapter = AuthorAdapter()
        binding.recyclerViewAuthor.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is BookListUiState.Loading -> {
                            changeVisibility(View.GONE, View.VISIBLE, R.string.text_view_info_message_loading)
                        }
                        is BookListUiState.Success -> {
                            adapter.setList(uiState.authorModelList)
                            changeVisibility(View.VISIBLE, View.GONE)
                        }
                        is BookListUiState.Error -> {
                            changeVisibility(View.GONE, View.VISIBLE, uiState.errorMessage)
                        }
                    }
                }
            }
        }
    }

    private suspend fun changeVisibility(
        recyclerViewVisibility: Int,
        textViewVisibility: Int,
        textViewTextResource: Int? = null
    ) = withContext(Dispatchers.Main) {
        with(binding) {
            recyclerViewAuthor.visibility = recyclerViewVisibility
            tvInfo.visibility = textViewVisibility
            textViewTextResource?.let { tvInfo.text = getString(it) }
        }
    }
}