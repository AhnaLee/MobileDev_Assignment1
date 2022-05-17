package com.codinginflow.mvvmtodo.util

import androidx.appcompat.widget.SearchView

inline fun SearchView.onQueryTextChanged(crossinline listener: (String) -> Unit) { //video 6
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true //don't wanna do anything
        }

        override fun onQueryTextChange (newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }
    })
}