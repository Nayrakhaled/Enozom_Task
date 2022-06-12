package com.example.enozomtask.network

import android.util.Log
import com.example.enozomtask.Model
import com.example.enozomtask.TextRemoteSource
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class TextRepo private constructor(private val source: TextRemoteSource) {

    companion object {

        private val textRepo: TextRepo? = null

        fun getInstance(remoteSource: TextRemoteSource): TextRepo {

            return textRepo ?: TextRepo(remoteSource)
        }
    }


    suspend fun getText(): Model {
        return source.getText()
    }

    suspend fun postText(res: String): RequestBody {

        val jsonReq = JSONObject()

        jsonReq.put("Password", res)


        val requestBody = jsonReq.toString().toRequestBody("application/json".toMediaTypeOrNull())

        Log.i("getRequest", "string to Request:  $jsonReq ")

        return requestBody
    }

}