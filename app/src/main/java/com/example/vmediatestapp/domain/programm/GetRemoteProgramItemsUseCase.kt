package com.example.vmediatestapp.domain.programm

import javax.inject.Inject

class GetRemoteProgramItemsUseCase @Inject constructor(
    private val repository: ProgramRepository
) {

    suspend fun getRemoteProgramItems() = repository.getRemoteProgramItems()

}