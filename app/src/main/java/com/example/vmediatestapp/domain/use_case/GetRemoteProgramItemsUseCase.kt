package com.example.vmediatestapp.domain.use_case

import com.example.vmediatestapp.domain.repository.ProgramRepository
import javax.inject.Inject

class GetRemoteProgramItemsUseCase @Inject constructor(
    private val repository: ProgramRepository
) {

    suspend fun getRemoteProgramItems() = repository.getRemoteProgramItems()

}