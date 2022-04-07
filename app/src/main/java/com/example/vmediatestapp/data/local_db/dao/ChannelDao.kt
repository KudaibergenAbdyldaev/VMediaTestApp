package com.example.vmediatestapp.data.local_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vmediatestapp.data.local_db.model.ChannelEntity

@Dao
interface ChannelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChannels(channel: List<ChannelEntity>)

    @Query("SELECT * FROM channel")
    fun getChannelMovie(): List<ChannelEntity>
}