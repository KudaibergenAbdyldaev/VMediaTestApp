package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.local_db.dao.ChannelDao
import com.example.vmediatestapp.data.mapper.ChannelMapper
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.domain.channel.ChannelRepository
import com.example.vmediatestapp.domain.channel.Channel
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: ChannelMapper,
    private val channelDao: ChannelDao
) : ChannelRepository {

    override suspend fun getRemoteChannels(): List<Channel> {
        return mapper.mapChannelDtoListToChannelList(apiInterface.getChannels())
    }

    override suspend fun getLocalChannels(): List<Channel> {
        return mapper.mapChannelEntityListToChannelList(channelDao.getChannels())
    }

}