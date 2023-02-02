package com.example.xcompanyassignment.domain

import com.example.xcompanyassignment.data.local.LocalRepoStorage
import com.example.xcompanyassignment.data.remote.RemoteRepoStorage
import io.reactivex.Observable
import io.reactivex.Single

internal class RepositoriesRepositoryImpl(
    private val remoteStorage: RemoteRepoStorage,
    private val localStorage: LocalRepoStorage,
) : RepoRepository {

    override fun getRepositories(): Observable<List<RepoData>> {
        val fromDb = localStorage.getRepositoryList().toObservable()
        return remoteStorage.getRepositoryList()
            .toObservable()
            .flatMapCompletable {
                localStorage.saveRepoList(it)
            }
            .andThen(fromDb)
    }

    override fun getRepositoryDetails(repositoryFullName: String): Single<List<Commit>> {
        return remoteStorage.getRepositoryDetails(repositoryFullName)
    }
}