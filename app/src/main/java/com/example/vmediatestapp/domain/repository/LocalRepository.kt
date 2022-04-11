package com.example.vmediatestapp.domain.repository

import com.example.vmediatestapp.domain.model.Channel
import com.example.vmediatestapp.domain.model.ChannelAndProgram
import com.example.vmediatestapp.domain.model.ProgramItem


interface LocalRepository {
    suspend fun insert(channels: List<Channel>,
                       programItems: List<ProgramItem>)
    suspend fun getLocal(): List<ChannelAndProgram>
}