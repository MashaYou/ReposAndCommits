package com.example.xcompanyassignment.data.local

import com.example.xcompanyassignment.data.toData
import com.example.xcompanyassignment.data.toEntity
import com.example.xcompanyassignment.domain.RepoData
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

internal class LocalRepoStorage @Inject constructor(
    private val db: AppDatabase,
    private val scheduler: Scheduler,
) {

    fun getRepositoryList(): Single<List<RepoData>> {
        return db.getRepositoriesDao().getAll()
            .map { list -> list.map { it.toData() } }
            .subscribeOn(scheduler)
    }

    fun saveRepoList(list: List<RepoData>): Completable {
        return db.getRepositoriesDao()
            .addList(list.map { it.toEntity() })
            .subscribeOn(scheduler)
    }
}
