package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "channel_and_programs")
data class ChannelAndProgramEntity(
    val channel: ChannelEntity,
    val programs: List<ProgramItemEntity>,
    @PrimaryKey(autoGenerate = true)
    val id: Int?=0,
)