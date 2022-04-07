package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.mapper.ChannelMapper
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.domain.channel.ChanelRepository
import com.example.vmediatestapp.domain.channel.Channel
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: ChannelMapper
) : ChanelRepository {

    override suspend fun getChannels(): List<Channel> {
        return mapper.mapChannelDtoListToChannelList(apiInterface.getChannels())
    }

}