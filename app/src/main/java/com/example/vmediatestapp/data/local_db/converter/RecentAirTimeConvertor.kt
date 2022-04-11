package com.example.vmediatestapp.data.local_db.converter

import androidx.room.TypeConverter
import com.example.vmediatestapp.data.local_db.model.RecentAirTimeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecentAirTimeConvertor {

    @TypeConverter
    fun fromGroupTaskMemberList(value: RecentAirTimeEntity): String {
        val gson = Gson()
        val type = object : TypeToken<RecentAirTimeEntity>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toGroupTaskMemberList(value: String): RecentAirTimeEntity {
        val gson = Gson()
        val type = object : TypeToken<RecentAirTimeEntity>() {}.type
        return gson.fromJson(value, type)
    }

}