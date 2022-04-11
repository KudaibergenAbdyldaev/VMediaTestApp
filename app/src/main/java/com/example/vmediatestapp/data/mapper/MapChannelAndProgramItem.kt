package com.example.vmediatestapp.data.mapper

import com.example.vmediatestapp.domain.ChannelAndProgram
import com.example.vmediatestapp.domain.channel.Channel
import com.example.vmediatestapp.domain.programm.ProgramItem
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


}