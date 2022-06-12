package com.example.enozomtask

import RetrofitService
import com.example.mcommerceapp.network.RetrofitHelper
import okhttp3.RequestBody



class TextRemoteSource :IText {

        private val api: RetrofitService =
            RetrofitHelper.getInstance().create(RetrofitService::class.java)

    override suspend fun getText() : Model {
        return api.getText()
    }

    override suspend fun postText(model: RequestBody) {
        api.postText(requestBody =  model)
    }

}