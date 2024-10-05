package com.empty.empty_project.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.empty.empty_project.db.tentities.TEntity

@Database(entities = [TEntity::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun TDao(): TDao
}
