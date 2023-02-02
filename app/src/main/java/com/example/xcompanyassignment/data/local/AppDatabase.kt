package com.example.xcompanyassignment.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        RepoEntity::class,
    ],
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun getRepositoriesDao(): ReposDao
}