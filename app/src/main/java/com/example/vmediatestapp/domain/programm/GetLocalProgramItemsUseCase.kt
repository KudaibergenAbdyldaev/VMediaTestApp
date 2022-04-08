package com.example.vmediatestapp.domain.programm

import javax.inject.Inject

class GetLocalProgramItemsUseCase @Inject constructor(
    private val repository: ProgramRepository
) {

    suspend fun getLocalProgramItems() = repository.getLocalProgramItems()

}