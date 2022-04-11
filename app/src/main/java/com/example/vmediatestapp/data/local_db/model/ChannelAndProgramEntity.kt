package com.example.vmediatestapp.data.local_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.vmediatestapp.data.local_db.converter.ChannelEntityConvertor
import com.example.vmediatestapp.data.local_db.converter.ProgramItemEntityConvertor

@Entity(tableName = "channel_and_programs")
@TypeConverters(ChannelEntityConvertor::class, ProgramItemEntityConvertor::class)
data class ChannelAndProgramEntity(
    @PrimaryKey
    val channel: ChannelEntity,
    val programs: List<ProgramItemEntity>
)