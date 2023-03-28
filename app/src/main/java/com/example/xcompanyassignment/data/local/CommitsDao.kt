package com.example.xcompanyassignment.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CommitsDao {

    @Transaction
    @Query("SELECT * FROM commits WHERE repo_id = :repoId")
    fun getCommits(repoId: Long): List<CommitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<CommitEntity>): Completable

    @Query("DELETE FROM Commits")
    fun deleteAllCommits(): Completable
}