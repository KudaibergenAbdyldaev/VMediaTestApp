package com.example.vmediatestapp.data.local_db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vmediatestapp.data.local_db.dao.ChannelDao
import com.example.vmediatestapp.data.local_db.dao.ProgramItemsDao
import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity


@Database(
    entities = [ChannelEntity::class, ProgramItemEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun channelsDao(): ChannelDao
    abstract fun programsDao(): ProgramItemsDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "popular_movie.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = db
                return db
            }
        }

    }

}