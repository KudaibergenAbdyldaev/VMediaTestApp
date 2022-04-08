package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity
import com.example.vmediatestapp.data.local_db.model.RecentAirTimeEntity
import com.example.vmediatestapp.data.network.model.ProgramItemDto
import com.example.vmediatestapp.data.network.model.RecentAirTimeDto
import com.example.vmediatestapp.domain.programm.ProgramItem
import com.example.vmediatestapp.domain.programm.RecentAirTime
import javax.inject.Inject

class ProgramMapper @Inject constructor(){

    //Dto to Domain model
    fun mapProgramDtoListToProgramList(dto: List<ProgramItemDto>): List<ProgramItem> {
        val list = mutableListOf<ProgramItem>()
        dto.forEach { list.add(mapProgramDtoToProgram(it)) }
        return list
    }

    private fun mapProgramDtoToProgram(dto: ProgramItemDto): ProgramItem {
        return ProgramItem(
            dto.startTime,
            mapRecentAirTimeDtoToRecentAirTime(dto.recentAirTime),
            dto.length,
            dto.shortName,
            dto.name
        )
    }

    private fun mapRecentAirTimeDtoToRecentAirTime(dto: RecentAirTimeDto): RecentAirTime {
        return RecentAirTime(dto.id, dto.channelID)
    }

    //Entity to Domain model
    fun mapProgramEntityListToProgramList(entity: List<ProgramItemEntity>): List<ProgramItem> {
        val list = mutableListOf<ProgramItem>()
        entity.forEach { list.add(mapProgramEntityToProgram(it)) }
        return list
    }

    private fun mapProgramEntityToProgram(entity: ProgramItemEntity): ProgramItem {
        return ProgramItem(
            entity.startTime,
            mapRecentAirTimeEntityToRecentAirTime(entity.recentAirTime),
            entity.length,
            entity.shortName,
            entity.name
        )
    }

    private fun mapRecentAirTimeEntityToRecentAirTime(entity: RecentAirTimeEntity): RecentAirTime {
        return RecentAirTime(entity.id, entity.channelID)
    }

    //Dto to Entity
    fun mapProgramDtoListToProgramEntityList(dto: List<ProgramItemDto>): List<ProgramItemEntity> {
        val list = mutableListOf<ProgramItemEntity>()
        dto.forEach { list.add(mapProgramDtoToProgramEntity(it)) }
        return list
    }

    private fun mapProgramDtoToProgramEntity(dto: ProgramItemDto): ProgramItemEntity {
        return ProgramItemEntity(
            dto.startTime,
            mapRecentAirTimeDtoToRecentAirTimeEntity(dto.recentAirTime),
            dto.length,
            dto.shortName,
            dto.name
        )
    }

    private fun mapRecentAirTimeDtoToRecentAirTimeEntity(dto: RecentAirTimeDto): RecentAirTimeEntity {
        return RecentAirTimeEntity(dto.id, dto.channelID)
    }

}