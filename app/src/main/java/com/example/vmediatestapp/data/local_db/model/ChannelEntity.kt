package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel")
data class ChannelEntity(
    val orderNum: Int,
    val accessNum: Int,
    val callSign: String,
    @PrimaryKey val id: Int
)