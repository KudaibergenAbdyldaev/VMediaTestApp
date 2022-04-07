package com.example.vmediatestapp.domain.programm

data class ProgramItem(
    val startTime: String,
    val recentAirTime: RecentAirTime,
    val length: String,
    val shortName: String,
    val name: String,
)