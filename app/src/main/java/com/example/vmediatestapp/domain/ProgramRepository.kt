package com.example.vmediatestapp.domain

interface ProgramRepository {
    fun getProgramItems(): List<ProgramItem>
}