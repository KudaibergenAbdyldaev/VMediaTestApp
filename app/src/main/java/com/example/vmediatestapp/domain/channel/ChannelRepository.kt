package com.example.vmediatestapp.domain.channel

interface ChannelRepository {
    suspend fun getRemoteChannels(): List<Channel>
    suspend fun getLocalChannels(): List<Channel>
}