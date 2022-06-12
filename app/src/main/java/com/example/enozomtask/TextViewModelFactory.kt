package com.example.enozomtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.network.TextRepo

class TextViewModelFactory(private val iText: TextRepo) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(TextViewModel::class.java)) {
            TextViewModel(iText) as T
        } else {
            throw IllegalArgumentException("Error")
        }
    }
}

