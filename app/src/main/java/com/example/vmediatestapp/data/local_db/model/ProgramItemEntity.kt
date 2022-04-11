package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.vmediatestapp.data.local_db.converter.RecentAirTimeConvertor


@TypeConverters(RecentAirTimeConvertor::class)
data class ProgramItemEntity(
    val startTime: String,
    val recentAirTime: RecentAirTimeEntity,
    val length: String,
    @PrimaryKey val name: String,
)