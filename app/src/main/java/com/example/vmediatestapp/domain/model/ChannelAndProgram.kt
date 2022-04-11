package com.example.vmediatestapp.domain.model

data class ChannelAndProgram(
    val channel: Channel,
    val programs: List<ProgramItem>
)