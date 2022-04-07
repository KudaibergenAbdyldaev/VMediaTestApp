package com.example.vmediatestapp.domain.channel

interface ChanelRepository {
    suspend fun getRemoteChannels(): List<Channel>
    suspend fun getLocalChannels(): List<Channel>
}