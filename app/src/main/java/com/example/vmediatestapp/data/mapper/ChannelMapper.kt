package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.domain.channel.Channel

class ChannelMapper {

    fun mapChannelDtoListToChannelList(dto: List<ChannelDto>): List<Channel> {
        val list = mutableListOf<Channel>()
        dto.forEach { list.add(mapChannelDtoToChannel(it)) }
        return list
    }

    private fun mapChannelDtoToChannel(dto: ChannelDto): Channel {
        return Channel(dto.orderNum, dto.accessNum, dto.callSign, dto.id)
    }


    fun mapChannelEntityListToChannelList(dto: List<ChannelEntity>): List<Channel> {
        val list = mutableListOf<Channel>()
        dto.forEach { list.add(mapChannelEntityToChannel(it)) }
        return list
    }

    private fun mapChannelEntityToChannel(entity: ChannelEntity): Channel {
        return Channel(entity.orderNum, entity.accessNum, entity.callSign, entity.id)
    }

}