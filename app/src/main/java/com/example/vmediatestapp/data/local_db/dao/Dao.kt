package com.example.vmediatestapp.data.local_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.vmediatestapp.data.local_db.model.ChannelAndProgramEntity

@Dao
interface Dao {
    @Insert
    suspend fun insertProgramItems(programItems: List<ChannelAndProgramEntity>)

    @Query("SELECT * FROM channel_and_programs")
    suspend fun getProgramItems(): List<ChannelAndProgramEntity>

    @Query("DELETE FROM channel_and_programs")
    fun deleteAll()
}