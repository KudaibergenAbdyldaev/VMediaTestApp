package com.example.vmediatestapp.data.local_db.converter

import androidx.room.TypeConverter
import com.example.vmediatestapp.data.local_db.model.ChannelEntity
import com.example.vmediatestapp.data.local_db.model.RecentAirTimeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ChannelEntityConvertor {

    @TypeConverter
    fun objectToString(value: ChannelEntity): String {
        val gson = Gson()
        val type = object : TypeToken<ChannelEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun objectFromString(value: String): ChannelEntity {
        val gson = Gson()
        val type = object : TypeToken<ChannelEntity>() {}.type
        return gson.fromJson(value, type)
    }

}