package com.example.vmediatestapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ChannelDto(
    @SerializedName("orderNum") val orderNum: Int,
    @SerializedName("accessNum") val accessNum: Int,
    @SerializedName("CallSign") val callSign: String,
    @SerializedName("id") val id: Int
)