package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.data.network.model.ProgramItemDto
import com.example.vmediatestapp.data.network.model.RecentAirTimeDto
import com.example.vmediatestapp.domain.programm.ProgramItem
import com.example.vmediatestapp.domain.programm.RecentAirTime

class ProgramMapper {

    fun mapProgramDtoToProgram(dto: ProgramItemDto): ProgramItem {
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

}