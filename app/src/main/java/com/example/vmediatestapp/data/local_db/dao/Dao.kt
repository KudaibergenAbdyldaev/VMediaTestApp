package com.example.vmediatestapp.data.local_db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vmediatestapp.data.local_db.model.ChannelAndProgramEntity

interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgramItems(programItems: List<ChannelAndProgramEntity>)

    @Query("SELECT * FROM program")
    suspend fun getProgramItems(): List<ChannelAndProgramEntity>
}