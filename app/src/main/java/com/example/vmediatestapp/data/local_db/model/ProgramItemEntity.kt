package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity

@Entity(tableName = "program")
data class ProgramItemEntity(
    val startTime: String,
    val recentAirTime: RecentAirTimeEntity,
    val length: String,
    val shortName: String,
    val name: String,
)