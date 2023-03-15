package com.example.mvvm.presentation.main.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.presentation.main.model.AuthorModel

class AuthorAdapter : RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>() {

    private var authorList = emptyList<AuthorModel>()

    class AuthorViewHolder(
        view : View,
        val textViewAuthorName: TextView = view.findViewById(R.id.tv_AuthorName),
        val textViewBooks: TextView = view.findViewById(R.id.tv_books)
    ) : RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_author_layout,parent,false)
        return AuthorViewHolder(view)
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {

        holder.textViewAuthorName.text = authorList[position].name
        holder.textViewBooks.text = authorList[position].booksList.getBooks()
    }

    override fun getItemCount(): Int {
        return authorList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AuthorModel>) {
        authorList = list
        notifyDataSetChanged()
    }
}

fun List<String>.getBooks(): String {
    return if (isEmpty()) {
        "У автора нет книг"
    } else {
        joinToString(separator = "\n")
    }
}