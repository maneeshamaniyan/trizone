package com.example.trizone.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
/*Created by Maneesha on 22/01/2022*/
data class NSDataModel (
    @Expose
    @SerializedName("albumId")
    val albumid: Integer,
    @Expose
    @SerializedName("id")
    val id: Integer,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("url")
    val url: String,
    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailurl: String
        )

