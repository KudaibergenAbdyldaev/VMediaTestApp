package com.example.vmediatestapp.domain.use_case

import com.example.vmediatestapp.domain.repository.LocalRepository
import javax.inject.Inject

class DeleteLocalDBUseCase @Inject constructor(private val repository: LocalRepository) {

    suspend fun deleteAll(){
        repository.delete()
    }

}