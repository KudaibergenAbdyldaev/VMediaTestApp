package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.domain.channel.Channel
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

    //Entity to Domain model
    fun mapChannelEntityListToChannelList(entity: List<ChannelEntity>): List<Channel> {
        val list = mutableListOf<Channel>()
        entity.forEach { list.add(mapChannelEntityToChannel(it)) }
        return list
    }

    private fun mapChannelEntityToChannel(entity: ChannelEntity): Channel {
        return Channel(entity.orderNum, entity.accessNum, entity.callSign, entity.id)
    }

    //Dto to Entity
    fun mapChannelDtoListToChannelEntityList(entity: List<ChannelDto>): List<ChannelEntity> {
        val list = mutableListOf<ChannelEntity>()
        entity.forEach { list.add(mapChannelDtoToChannelEntity(it)) }
        return list
    }

    private fun mapChannelDtoToChannelEntity(dto: ChannelDto): ChannelEntity {
        return ChannelEntity(dto.orderNum, dto.accessNum, dto.callSign, dto.id)
    }

}