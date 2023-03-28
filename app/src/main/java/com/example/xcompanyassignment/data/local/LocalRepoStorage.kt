package com.example.xcompanyassignment.data.local

import com.example.xcompanyassignment.data.remote.CommitDetailsDto
import com.example.xcompanyassignment.data.remote.RepositoryDto
import com.example.xcompanyassignment.data.toData
import com.example.xcompanyassignment.data.toEntity
import com.example.xcompanyassignment.domain.CommitData
import com.example.xcompanyassignment.domain.RepoData
import com.example.xcompanyassignment.mapList
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class LocalRepoStorage @Inject constructor(
    private val db: AppDatabase,
    private val scheduler: Scheduler,
) {

    fun getRepositoryList(): List<RepoData> {
        return db.getRepositoriesDao()
            .getAll()
            .mapList(::toData)
    }

    fun saveRepoList(list: List<RepositoryDto>): Completable {
        return db.getRepositoriesDao()
            .addList(list.map(::toEntity))
            .subscribeOn(scheduler)
    }

    fun deleteAllRepos(): Completable {
        return db.getRepositoriesDao()
            .deleteAllRepos()
            .subscribeOn(scheduler)
    }

    fun deleteAllCommits(): Completable {
        return db.getCommitsDao()
            .deleteAllCommits()
            .subscribeOn(scheduler)
    }

    fun getCommitsList(repoId: Long): List<CommitData> {
        return db.getCommitsDao()
            .getCommits(repoId)
            .mapList(::toData)
    }

    fun saveCommitsList(list: List<CommitDetailsDto>, repoId: Long): Completable {
        return db.getCommitsDao()
            .addList(list.map{ it.toEntity(repoId) })
                .subscribeOn(scheduler)
    }

    fun replaceCommits(newCommits: List<CommitDetailsDto>, repoId: Long) {
        deleteAllCommits()
            .andThen { saveCommitsList(newCommits, repoId) }
            .subscribeOn(scheduler)
            .subscribe()
    }

    fun replaceRepositories(newRepos: List<RepositoryDto>) {
        deleteAllRepos()
            .andThen { saveRepoList(newRepos) }
            .subscribeOn(scheduler)
            .subscribe()
    }
}
