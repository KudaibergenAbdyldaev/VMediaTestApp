package com.example.vmediatestapp.data.network.model

import com.google.gson.annotations.SerializedName

data class RecentAirTimeDto(
    @SerializedName("id") val id: Int,
    @SerializedName("channelID") val channelID: Int,
)