package com.example.vmediatestapp.domain.channel

import javax.inject.Inject

class InsertChannelsUseCase @Inject constructor(
    private val repository: ChannelRepository
) {

    suspend fun insertChannels(channel: List<Channel>) = repository.insertChannels(channel)

}