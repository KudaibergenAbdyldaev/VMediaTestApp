package com.example.vmediatestapp.domain.channel

import com.example.vmediatestapp.data.local_db.model.ChannelEntity

interface ChannelRepository {
    suspend fun getRemoteChannels(): List<Channel>
    suspend fun getLocalChannels(): List<Channel>
    suspend fun insertChannels(channel: List<ChannelEntity>)
}