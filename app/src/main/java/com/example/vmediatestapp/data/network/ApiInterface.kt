package com.example.vmediatestapp.data.network

import com.example.vmediatestapp.data.network.model.ChannelDto
import com.example.vmediatestapp.data.network.model.ProgramItemDto
import retrofit2.http.GET

interface ApiInterface {

    @GET("/json/Channels")
    suspend fun getChannels():List<ChannelDto>

    @GET("/json/ProgramItems")
    suspend fun getProgramItems():List<ProgramItemDto>

}