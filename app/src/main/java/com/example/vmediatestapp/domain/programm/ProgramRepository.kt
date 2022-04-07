package com.example.vmediatestapp.domain.programm

interface ProgramRepository {
    suspend fun getProgramItems(): List<ProgramItem>
}