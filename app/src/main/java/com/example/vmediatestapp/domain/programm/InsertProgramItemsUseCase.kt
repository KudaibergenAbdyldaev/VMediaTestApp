package com.example.vmediatestapp.domain.programm

import javax.inject.Inject

class InsertProgramItemsUseCase @Inject constructor(
    private val repository: ProgramRepository
) {

    suspend fun insertProgramItems(programItems: List<ProgramItem>) =
        repository.insertProgramItems(programItems)

}