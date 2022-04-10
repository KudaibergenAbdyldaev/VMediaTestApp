package com.example.vmediatestapp.domain.channel

import javax.inject.Inject

class GetRemoteChannelsUseCase @Inject constructor(
    private val repository: ChannelRepository
) {

    suspend fun getRemoteChannels() = repository.getRemoteChannels()

}