package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity

@Entity(tableName = "channel")
data class ChannelEntity(
    val orderNum: Int,
    val accessNum: Int,
    val callSign: String,
    val id: Int
)