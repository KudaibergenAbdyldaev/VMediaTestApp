package com.example.vmediatestapp.domain.channel

interface ChanelRepository {
    suspend fun getChannels():List<Channel>
}