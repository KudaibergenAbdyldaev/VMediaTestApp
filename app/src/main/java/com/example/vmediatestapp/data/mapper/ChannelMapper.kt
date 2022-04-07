package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.domain.channel.Channel

class ChannelMapper {

    private fun mapChannelDtoToChannel(dto: ChannelDto): Channel {
        return Channel(dto.orderNum, dto.accessNum, dto.callSign, dto.id)
    }

    fun mapChannelDtoListToChannelList(dto: List<ChannelDto>): List<Channel> {
        val list = mutableListOf<Channel>()
        dto.forEach { list.add(mapChannelDtoToChannel(it)) }
        return list
    }

}