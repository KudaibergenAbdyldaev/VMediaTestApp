package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.local_db.dao.ProgramItemsDao
import com.example.vmediatestapp.data.mapper.ProgramMapper
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.domain.programm.ProgramItem
import com.example.vmediatestapp.domain.programm.ProgramRepository
import javax.inject.Inject

class ProgramRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: ProgramMapper,
    private val programItemsDao: ProgramItemsDao
) : ProgramRepository {

    override suspend fun getRemoteProgramItems(): List<ProgramItem> {
        return mapper.mapProgramDtoListToProgramList(apiInterface.getProgramItems())
    }

    override suspend fun getLocalProgramItems(): List<ProgramItem> {
        return mapper.mapProgramEntityListToProgramList(programItemsDao.getProgramItems())
    }

}