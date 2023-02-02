package com.example.xcompanyassignment.data.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
internal interface ReposDao {

    @Query("SELECT * FROM Repositories")
    fun getAll(): Single<List<RepoEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<RepoEntity>): Completable
}