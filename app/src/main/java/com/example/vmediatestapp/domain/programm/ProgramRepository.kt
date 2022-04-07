package com.example.vmediatestapp.domain.programm

interface ProgramRepository {
    fun getProgramItems(): List<ProgramItem>
}