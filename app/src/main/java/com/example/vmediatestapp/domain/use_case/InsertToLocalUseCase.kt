package com.example.vmediatestapp.domain.use_case

import com.example.vmediatestapp.domain.model.Channel
import com.example.vmediatestapp.domain.model.ProgramItem
import com.example.vmediatestapp.domain.repository.LocalRepository
import javax.inject.Inject

class InsertToLocalUseCase @Inject constructor(private val repository: LocalRepository) {

    suspend fun insert(channels: List<Channel>,
                       programItems: List<ProgramItem>){
        repository.insert(channels, programItems)
    }

}