package com.example.enozomtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.network.TextRepo

class MainActivity : AppCompatActivity() {

    private lateinit var textVM: TextViewModel
    private lateinit var textVMFactory: TextViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textVMFactory = TextViewModelFactory(
            TextRepo.getInstance(TextRemoteSource())
        )
        textVM = ViewModelProvider(this, textVMFactory)[TextViewModel::class.java]

        textVM.getText()

        textVM.text.observe(this){
            val myIndexes = it.index?.split(",")

            val res = StringBuilder()

            if (myIndexes != null) {
                for(index in myIndexes){
                    res.append(it.text?.get(index.toInt()))
                }
            }
            textVM.postText(res.toString())
        }
    }
}