package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.mapper.ChannelMapper
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.domain.repository.ChannelRepository
import com.example.vmediatestapp.domain.model.Channel
import javax.inject.Inject

class ChannelRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: ChannelMapper
) : ChannelRepository {

    override suspend fun getRemoteChannels(): List<Channel> {
        return mapper.mapChannelDtoListToChannelList(apiInterface.getChannels())
    }

}