package com.example.vmediatestapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ProgramItemDto(
    @SerializedName("startTime") val startTime: String,
    @SerializedName("recentAirTime") val recentAirTime: RecentAirTimeDto,
    @SerializedName("length") val length: String,
    @SerializedName("name") val name: String,
)