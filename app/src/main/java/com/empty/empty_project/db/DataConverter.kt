package  com.empty.empty_project.db

import androidx.room.TypeConverter
import java.util.Date
import javax.inject.Singleton

@Singleton
class DataConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}