package com.example.vmediatestapp.di

import android.app.Application
import com.example.vmediatestapp.data.local_db.AppDatabase
import com.example.vmediatestapp.data.local_db.dao.ChannelDao
import com.example.vmediatestapp.data.local_db.dao.ProgramItemsDao
import com.example.vmediatestapp.data.mapper.ChannelMapper
import com.example.vmediatestapp.data.mapper.ProgramMapper
import com.example.vmediatestapp.data.network.ApiFactory
import com.example.vmediatestapp.data.network.ApiInterface
import com.example.vmediatestapp.data.repository.ChannelRepositoryImpl
import com.example.vmediatestapp.data.repository.ProgramRepositoryImpl
import com.example.vmediatestapp.domain.channel.ChannelRepository
import com.example.vmediatestapp.domain.programm.ProgramRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @AppScope
    fun bindChannelRepository(impl: ChannelRepositoryImpl): ChannelRepository

    @Binds
    @AppScope
    fun bindProgramRepository(impl: ProgramRepositoryImpl): ProgramRepository

    companion object{

        @Provides
        @AppScope
        fun provideApiService(): ApiInterface {
            return ApiFactory().apiService
        }

        @Provides
        @AppScope
        fun provideChannelMapper(): ChannelMapper {
            return ChannelMapper()
        }

        @Provides
        @AppScope
        fun provideProgramMapper(): ProgramMapper {
            return ProgramMapper()
        }

        @Provides
        @AppScope
        fun provideAppDataBase(
            application: Application
        ): AppDatabase {
            return AppDatabase.getInstance(application)
        }

        @Provides
        @AppScope
        fun provideChannelDao(
            application: Application
        ): ChannelDao {
            return AppDatabase.getInstance(application).channelsDao()
        }

        @Provides
        @AppScope
        fun provideProgramDao(
            application: Application
        ): ProgramItemsDao {
            return AppDatabase.getInstance(application).programsDao()
        }

    }

}