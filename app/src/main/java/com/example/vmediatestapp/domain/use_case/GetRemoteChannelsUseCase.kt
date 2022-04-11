package com.example.vmediatestapp.domain.use_case

import com.example.vmediatestapp.domain.repository.ChannelRepository
import javax.inject.Inject

class GetRemoteChannelsUseCase @Inject constructor(
    private val repository: ChannelRepository
) {

    suspend fun getRemoteChannels() = repository.getRemoteChannels()

}