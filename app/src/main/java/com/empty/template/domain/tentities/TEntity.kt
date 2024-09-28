package com.empty.template.domain.tentities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ttable")
data class TEntity(
    @PrimaryKey private val id: Int,
)