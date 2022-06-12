package com.example.enozomtask

import okhttp3.RequestBody

interface IText {
    suspend fun getText() : Model

    suspend fun postText(model: RequestBody)
}