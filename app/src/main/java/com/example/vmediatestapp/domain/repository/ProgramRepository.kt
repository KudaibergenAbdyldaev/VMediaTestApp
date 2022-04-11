package com.example.vmediatestapp.domain.repository

import com.example.vmediatestapp.domain.model.ProgramItem


interface ProgramRepository {
    suspend fun getRemoteProgramItems(): List<ProgramItem>
}