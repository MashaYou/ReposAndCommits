package com.example.xcompanyassignment.data.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
internal interface ReposDao {

    @Query("SELECT * FROM Repositories")
    fun getAll(): List<RepoEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<RepoEntity>): Completable

    @Query("DELETE FROM Repositories")
    fun deleteAllRepos(): Completable
}