package com.empty.empty_project.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.empty.empty_project.db.AppDatabase
import com.empty.empty_project.db.TDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        )
            .fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)

                }
            })
            .build()
    }

    @Provides
    fun provideTDao(appDatabase: AppDatabase): TDao {
        return appDatabase.TDao()
    }

}