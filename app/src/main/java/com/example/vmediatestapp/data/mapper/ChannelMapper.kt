package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.domain.channel.Channel

class ChannelMapper {

    fun mapChannelDtoToChannel(dto: ChannelDto): Channel {
        return Channel(dto.orderNum, dto.accessNum, dto.callSign, dto.id)
    }

}