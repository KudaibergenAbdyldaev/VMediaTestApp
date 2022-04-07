package com.example.vmediatestapp.data.repository

import com.example.vmediatestapp.data.mapper.ProgramMapper
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.domain.programm.ProgramItem
import com.example.vmediatestapp.domain.programm.ProgramRepository
import javax.inject.Inject

class ProgramRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
    private val mapper: ProgramMapper
) : ProgramRepository {

    override suspend fun getProgramItems(): List<ProgramItem> {
        return mapper.mapProgramDtoListToProgramList(apiInterface.getProgramItems())
    }

}