package com.example.vmediatestapp.data.local_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity

@Dao
interface ProgramItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProgramItems(programItems: List<ProgramItemEntity>)

    @Query("SELECT * FROM program")
    suspend fun getProgramItems(): List<ProgramItemEntity>
}