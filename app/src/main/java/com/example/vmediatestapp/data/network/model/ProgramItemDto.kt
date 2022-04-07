package com.example.vmediatestapp.data.network.model

data class ProgramItemDto(
    val startTime: String,
    val recentAirTime: RecentAirTimeDto,
    val length: String,
    val shortName: String,
    val name: String,
)