package com.example.vmediatestapp.domain.use_case

import com.example.vmediatestapp.domain.repository.LocalRepository
import javax.inject.Inject

class GetLocalUseCase @Inject constructor(
    private val repository: LocalRepository
) {

    suspend fun getLocal() = repository.getLocal()

}