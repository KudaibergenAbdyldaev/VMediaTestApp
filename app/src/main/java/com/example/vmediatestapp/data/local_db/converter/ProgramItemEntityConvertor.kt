package com.example.vmediatestapp.data.local_db.converter

import androidx.room.TypeConverter
import com.example.vmediatestapp.data.local_db.model.ProgramItemEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProgramItemEntityConvertor {
    @TypeConverter
    fun objectToString(value: List<ProgramItemEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<List<ProgramItemEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun objectFromString(value: String): List<ProgramItemEntity> {
        val gson = Gson()
        val type = object : TypeToken<List<ProgramItemEntity>>() {}.type
        return gson.fromJson(value, type)
    }
}