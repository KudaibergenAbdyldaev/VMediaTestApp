package com.example.vmediatestapp.domain.channel


import javax.inject.Inject

class GetLocalChannelsUseCase @Inject constructor(
    private val repository: ChannelRepository
) {

    suspend fun getLocalChannels() = repository.getLocalChannels()

}