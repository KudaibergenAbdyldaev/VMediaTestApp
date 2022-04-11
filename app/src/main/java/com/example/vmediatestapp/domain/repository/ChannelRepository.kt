package com.example.vmediatestapp.domain.repository

import com.example.vmediatestapp.domain.model.Channel


interface ChannelRepository {
    suspend fun getRemoteChannels(): List<Channel>
}