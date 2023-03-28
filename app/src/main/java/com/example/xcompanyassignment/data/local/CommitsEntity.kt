package com.example.xcompanyassignment.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Commits",
    foreignKeys = [
        ForeignKey(
            entity = RepoEntity::class,
            parentColumns = ["id"],
            childColumns = ["repo_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
)
internal data class CommitEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "repo_id") val repoId: Long,
    val sha: String,
    val name: String,
    val email: String,
    val date: String,
    val message: String,
)