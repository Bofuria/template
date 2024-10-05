package com.empty.empty_project.db.tentities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ttable")
data class TEntity(
    @PrimaryKey private val id: Int,
)