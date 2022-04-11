package com.example.vmediatestapp.data.mapper


import com.example.vmediatestapp.data.network.model.ProgramItemDto
import com.example.vmediatestapp.data.network.model.RecentAirTimeDto
import com.example.vmediatestapp.domain.model.ProgramItem
import com.example.vmediatestapp.domain.model.RecentAirTime
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
            dto.name
        )
    }

    private fun mapRecentAirTimeDtoToRecentAirTime(dto: RecentAirTimeDto): RecentAirTime {
        return RecentAirTime(dto.id, dto.channelID)
    }

}