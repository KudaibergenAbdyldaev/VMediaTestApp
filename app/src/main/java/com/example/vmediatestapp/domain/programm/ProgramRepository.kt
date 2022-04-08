package com.example.vmediatestapp.domain.programm


interface ProgramRepository {
    suspend fun getRemoteProgramItems(): List<ProgramItem>
    suspend fun getLocalProgramItems(): List<ProgramItem>
    suspend fun insertProgramItems(programItems: List<ProgramItem>)
}