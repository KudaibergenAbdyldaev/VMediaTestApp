package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.local_db.dao.Dao
import com.example.vmediatestapp.data.mapper.MapChannelAndProgramItem
import com.example.vmediatestapp.domain.model.ChannelAndProgram
import com.example.vmediatestapp.domain.repository.LocalRepository
import com.example.vmediatestapp.domain.model.Channel
import com.example.vmediatestapp.domain.model.ProgramItem
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    val mapper: MapChannelAndProgramItem,
    private val dao: Dao
) : LocalRepository {

    override suspend fun insert(channels: List<Channel>, programItems: List<ProgramItem>) {
        dao.insertProgramItems(mapper.mapToChannelAndProgramItemsEntity(channels, programItems))
    }

    override suspend fun getLocal(): List<ChannelAndProgram> {
        return mapper.mapListChannelAndProgramEntityToModelList(dao.getProgramItems())
    }

    override suspend fun delete() {
        dao.deleteAll()
    }
}