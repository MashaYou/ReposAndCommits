package com.example.xcompanyassignment.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Repositories",
)
internal data class RepoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val fullName: String,
    val description: String?,
    val imageUrl: String?,
)