package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.domain.model.Channel
import javax.inject.Inject

class ChannelMapper @Inject constructor(){

    //Dto to Domain model
    fun mapChannelDtoListToChannelList(dto: List<ChannelDto>): List<Channel> {
        val list = mutableListOf<Channel>()
        dto.forEach { list.add(mapChannelDtoToChannel(it)) }
        return list
    }

    private fun mapChannelDtoToChannel(dto: ChannelDto): Channel {
        return Channel(dto.orderNum, dto.accessNum, dto.callSign, dto.id)
    }

}