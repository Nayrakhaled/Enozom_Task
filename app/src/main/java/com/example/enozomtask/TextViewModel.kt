package com.example.enozomtask

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enozomtask.network.TextRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TextViewModel(
    private val iText: TextRepo
) : ViewModel() {


    private val _text = MutableLiveData<Model>()
    var text: LiveData<Model> = _text


    fun getText() {
        viewModelScope.launch(Dispatchers.IO) {
            val text = iText.getText()
            Log.d("text", text.toString())
            withContext(Dispatchers.Main) {
                _text.postValue(text)
            }
        }
    }

    fun postText(res: String) {
        viewModelScope.launch(Dispatchers.IO) {

            iText.postText(res)
        }
    }

}