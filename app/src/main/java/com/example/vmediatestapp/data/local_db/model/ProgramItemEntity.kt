package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity
import com.example.vmediatestapp.domain.programm.RecentAirTime

@Entity(tableName = "program")
data class ProgramItemEntity(
    val startTime: String,
    val recentAirTime: RecentAirTime,
    val length: String,
    val shortName: String,
    val name: String,
)