package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.local_db.model.ChannelAndProgramEntity
import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity
import com.example.vmediatestapp.data.local_db.model.RecentAirTimeEntity
import com.example.vmediatestapp.domain.model.ChannelAndProgram
import com.example.vmediatestapp.domain.model.Channel
import com.example.vmediatestapp.domain.model.ProgramItem
import com.example.vmediatestapp.domain.model.RecentAirTime
import javax.inject.Inject

class MapChannelAndProgramItem @Inject constructor() {

    fun mapToChannelAndProgramItems(
        channels: List<Channel>,
        programItems: List<ProgramItem>
    ): List<ChannelAndProgram> {

        val list = mutableListOf<ChannelAndProgram>()

        for (channel in channels) {

            val programs = mutableListOf<ProgramItem>()

            for (program in programItems) {

                if (channel.id == program.recentAirTime.channelID) {
                    programs.add(program)
                }

            }
            list.add(ChannelAndProgram(channel, programs))
        }

        return list
    }

    fun mapToChannelAndProgramItemsEntity(
        channels: List<Channel>,
        programItems: List<ProgramItem>
    ): List<ChannelAndProgramEntity> {

        val list = mutableListOf<ChannelAndProgramEntity>()

        for (channel in channels) {

            val programs = mutableListOf<ProgramItem>()

            for (program in programItems) {

                if (channel.id == program.recentAirTime.channelID) {
                    programs.add(program)
                }

            }
            list.add(
                ChannelAndProgramEntity(
                    mapChannelToChannelEntity(channel),
                    mapProgramListToProgramEntityList(programs)
                )
            )
        }

        return list
    }

    private fun mapChannelToChannelEntity(channel: Channel): ChannelEntity {
        return ChannelEntity(channel.orderNum, channel.accessNum, channel.callSign, channel.id)
    }

    private fun mapProgramListToProgramEntityList(entity: List<ProgramItem>): List<ProgramItemEntity> {
        val list = mutableListOf<ProgramItemEntity>()
        entity.forEach { list.add(mapProgramToProgramEntity(it)) }
        return list
    }

    private fun mapProgramToProgramEntity(entity: ProgramItem): ProgramItemEntity {
        return ProgramItemEntity(
            entity.startTime,
            mapRecentAirTimeToRecentAirTimeEntity(entity.recentAirTime),
            entity.length,
            entity.name
        )
    }

    private fun mapRecentAirTimeToRecentAirTimeEntity(entity: RecentAirTime): RecentAirTimeEntity {
        return RecentAirTimeEntity(entity.id, entity.channelID)
    }


    fun mapListChannelAndProgramEntityToModelList(entity: List<ChannelAndProgramEntity>): List<ChannelAndProgram> {
        val list = mutableListOf<ChannelAndProgram>()
        entity.forEach { list.add(mapChannelAndProgramEntityToModel(it.channel, it.programs)) }
        return list
    }

    private fun mapChannelAndProgramEntityToModel(
        channel: ChannelEntity,
        programs: List<ProgramItemEntity>
    ): ChannelAndProgram {
        return ChannelAndProgram(mapEntityToChannelToChannel(channel), mapEntityProgramListToProgramList(programs))
    }

    private fun mapEntityToChannelToChannel(channel: ChannelEntity): Channel {
        return Channel(channel.orderNum, channel.accessNum, channel.callSign, channel.id)
    }

    private fun mapEntityProgramListToProgramList(entity: List<ProgramItemEntity>): List<ProgramItem> {
        val list = mutableListOf<ProgramItem>()
        entity.forEach { list.add(mapProgramEntityToProgram(it)) }
        return list
    }

    private fun mapProgramEntityToProgram(entity: ProgramItemEntity): ProgramItem {
        return ProgramItem(
            entity.startTime,
            mapRecentAirTimeEntityToRecentAirTime(entity.recentAirTime),
            entity.length,
            entity.name
        )
    }

    private fun mapRecentAirTimeEntityToRecentAirTime(entity: RecentAirTimeEntity): RecentAirTime {
        return RecentAirTime(entity.id, entity.channelID)
    }

}