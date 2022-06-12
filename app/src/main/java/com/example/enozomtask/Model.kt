package com.example.enozomtask

import com.google.gson.annotations.SerializedName

data class Model(

    @SerializedName("Indexes") var index: String? = null,
    @SerializedName("Text") var text: String? = null
)