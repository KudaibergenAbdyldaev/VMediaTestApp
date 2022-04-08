package com.example.vmediatestapp.domain.programm

import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity

interface ProgramRepository {
    suspend fun getRemoteProgramItems(): List<ProgramItem>
    suspend fun getLocalProgramItems(): List<ProgramItem>
    suspend fun insertProgramItems(programItems: List<ProgramItemEntity>)
}